import "./datatable.scss";
import { DataGrid } from "@mui/x-data-grid";
import { userColumns } from "../../datatablesource_users";
import { Link } from "react-router-dom";
import { useEffect, useState } from "react";
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

  const [token, setToken] = useState("");
  const [employees, setEmployees] = useState([]);
  const getEmployees = (token) =>{
    fetch('http://192.168.1.8:8090/api/employes', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${token}`,

      },
    })
      .then(response => response.json())
      .then(data => {
        setEmployees(data);
      })
      .catch(error => {
        console.error('Error fetching employees:', error);
      });
  }
  useEffect(() => {
    let token = localStorage.getItem('token')
    getEmployees(token);
  }, []);
  const actionColumn = [
    {
      field: "action",
      headerName: "Action",
      width: 250,
      headerClassName: "customHeader",
      headerAlign: 'center',
      renderCell: (params) => {
        return (
          <div className="cellAction">
            <Link to="/users/test" style={{ textDecoration: "none" }}>
              <div className="viewButton">View</div>
            </Link>
          </div>
        );
      },
    },
  ];
  return (
    <div className="datatable">
      <div className="datatableTitle">
        List Employees
      </div>
      <StyledDataGrid
        className="datagrid"
        rows={employees}
        columns={userColumns.concat(actionColumn)}
        pageSize={9}
        rowsPerPageOptions={[9]}
        getRowId={(row) => row.idEmploye}

      />
    </div>
  );
};

export default Datatable;
