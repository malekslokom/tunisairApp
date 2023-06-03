import "./flight.scss";
import { DataGrid } from "@mui/x-data-grid";
import { flightMarchandise } from "../../datatablesource";
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
  const [flightMR, setFlightMR] = useState([]);
  const [token, setToken] = useState("");

  const getFlightMR = () =>{
    fetch('http://192.168.1.8:8090/api/volMarchandises', {
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
        setFlightMR(updatedFlightMR);
      })
      .catch(error => {
        console.error('Error fetching employees:', error);
      });
  }

  useEffect(() => {
    let token = localStorage.getItem('token')
    setToken(token);    
    getFlightMR();
  }, []);
  const actionColumn = [
    {
      field: "action",
      headerName: "Action",
      width: 200,
      headerClassName: "customHeader",
      headerAlign: 'center',
      renderCell: (params) => {
        const { numeroVol, aeroportDepart, aeroportDestination, dateDepart, dateArrivee,etat,typeMarchandise , poids} = params.row;

        return (
          <div className="cellAction">
            <Link
              to={`/flights/detail/mr/${numeroVol}?from=${encodeURIComponent(JSON.stringify(aeroportDepart))}&to=${aeroportDestination}&depart=${dateDepart}&arrive=${dateArrivee}&etat=${etat}&type=${typeMarchandise}&poids=${poids}`}
              style={{ textDecoration: "none" }}
            >
              <div className="viewButton">View</div>
            </Link>
         
          </div>
        );
      },
    },
  ];

  return (
    <div className="flight">
      <div className="flightTitle">
        List Flights Marchandise
      </div>
      <StyledDataGrid
        rows={flightMR}
        columns={flightMarchandise.concat(actionColumn)}
        pageSize={9}
        rowsPerPageOptions={[9]}
        getRowId={(row) => row.numeroVol}
      />
    </div>
  );
};

export default Datatable;
