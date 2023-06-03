import "./flight.scss";
import { DataGrid } from "@mui/x-data-grid";
import { flightTrip } from "../../datatablesource";
import { Link } from "react-router-dom";
import { useState, useEffect } from "react";
import styled from "styled-components";

const StyledDataGrid = styled(DataGrid)`
  && {
    .MuiDataGrid-root {
      border-radius: 8px;
      overflow: hidden;
    }

    .MuiDataGrid-row {
      cursor: pointer;
    }

    .MuiDataGrid-row.Mui-selected {
      background-color: rgba(0, 0, 0, 0.1);
    }

    .MuiDataGrid-cell {
      display: flex;
      align-items: center;
      justify-content: center;
      font-size: 14px;
    }
  }
`;

const Datatable = () => {
  const [flightTR, setFlightTR] = useState([]);
  const [token, setToken] = useState("");

  const getFlightTR = (token) =>{

    fetch('http://192.168.1.8:8090/api/volvoyageurs', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,

      },
    })
      .then(response => response.json())
      .then(data => {
        const updatedFlightMR = data.map(flight => ({
          ...flight,
          aeroportDepart: flight.aeroportDepart.nom,
          aeroportDestination: flight.aeroportDestination.nom,
        }));
        setFlightTR(updatedFlightMR);
      })
      .catch(error => {
        console.error('Error fetching employees:', error);
      });
  }
  useEffect(() => {
    let token = localStorage.getItem('token')
    setToken(token);
    getFlightTR(token);
  }, []);
  const deleteFlight = (flightNumber) => {
    fetch(`http://192.168.1.8:8090/api/volvoyageurs/${flightNumber}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,

      },
    })
    .then(response => response.json())
    .then(data => {
      const updatedFlightMR = data.map(flight => ({
        ...flight,
        aeroportDepart: flight.aeroportDepart.nom,
      }));
      setFlightTR(updatedFlightMR);

    })
    .catch(error => {
      console.error('Error deleting flight:', error);
    });
  }

  const actionColumn = [
    {
      field: "action",
      headerName: "Action",
      width: 200,
      headerClassName: "customHeader",
      headerAlign: 'center',
      renderCell: (params) => {
        const { numeroVol, aeroportDepart, aeroportDestination, dateDepart, dateArrivee,etat,type, nbPassagers } = params.row;

        return (
          <div className="cellAction">
            <Link
              to={`/flights/detail/tr/${numeroVol}?from=${aeroportDepart}&to=${aeroportDestination}&depart=${dateDepart}&arrive=${dateArrivee}&etat=${etat}&type=${type}&nbPassagers=${nbPassagers}`}
              style={{ textDecoration: "none" }}
            >
              <div className="viewButton">View</div>
            </Link>
            <div
              className="deleteButton"
              onClick={() => deleteFlight(params.row.numeroVol)}
            >
              Delete
            </div>
          </div>
        );
      },
    },
  ];

  return (
    <div className="flight">
      <div className="flightTitle">
        List Flights Trip
        <Link to="/flights/newTR" className="link">
          Add New
        </Link>
      </div>
      <StyledDataGrid
        rows={flightTR}
        columns={flightTrip.concat(actionColumn)}
        pageSize={9}
        rowsPerPageOptions={[9]}
        getRowId={(row) => row.numeroVol}
      />
    </div>
  );
};

export default Datatable;
