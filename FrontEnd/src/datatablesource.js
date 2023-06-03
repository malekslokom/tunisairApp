import logo from "./assets/images/logo-tab.png"
export const flightMarchandise = [
  {
    field: "company",
    headerName: "Company",
    headerClassName: "customHeader",
    headerAlign: 'center',
    width: 100,
    renderCell: () => {
      return (
        <div className="cellWithImg">
          <img className="cellImg" src={logo} alt="avatar" />
        </div>
      );
    },
  },
  { 
    field: "numeroVol", 
    headerClassName: "customHeader",
    headerName: "ID", 
    width: 70 ,
    headerAlign: 'center'
  },

  {
    field: "aeroportDepart",
    headerName: "From",
    width: 200,
    headerClassName: "customHeader",
    headerAlign: 'center',
    renderCell: (params) => {
      return (
        <div className="cellWithStatus">
          {params.row.aeroportDepart}
        </div>
      );
    },
  },

  {
    field: "aeroportDestination",
    headerName: "To",
    width: 200,
    headerClassName: "customHeader",
    headerAlign: 'center',
    renderCell: (params) => {
      return (
        <div className="cellWithStatus">
          {params.row.aeroportDestination}
        </div>
      );
    },
  },
  {
    field: "avion",
    headerName: "Airplane",
    width: 200,
    headerAlign: 'center',
    headerClassName: "customHeader",
    renderCell: (params) => {
      return (
        <div className="cellWithStatus">
          {params.row.avion.nomAvion}
        </div>
      );
    },
  },
  {
    field: "dateDepart",
    headerName: "Departure Date",
    width: 200,
    headerAlign: 'center',
    headerClassName: "customHeader",
    renderCell: (params) => {
      return (
        <div className="cellWithStatus">
          {params.row.dateDepart}
        </div>
      );
    },
  },
  {
    field: "dateArrivee",
    headerName: "Arrival Date",
    width: 200,
    headerAlign: 'center',
    headerClassName: "customHeader",
    renderCell: (params) => {
      return (
        <div className="cellWithStatus">
          {params.row.dateArrivee}
        </div>
      );
    },
  },
  {
    field: "etat",
    headerName: "Status",
    width: 160,
    headerClassName: "customHeader",
    headerAlign: 'center',
    renderCell: (params) => {
      return (
        <div className={`cellWithStatus ${params.row.etat}`}>
          {params.row.etat}
        </div>
      );
    },
  },
  {
    field: "typeMarchandise",
    headerName: "Type Marchandise",
    width: 160,
    headerClassName: "customHeader",
    headerAlign: 'center',
    renderCell: (params) => {
      return (
        <div className="cellWithStatus">
          {params.row.typeMarchandise}
        </div>
      );
    },
  },
  {
    field: "poids",
    headerName: "Weight",
    width: 160,
    headerClassName: "customHeader",
    headerAlign: 'center',
    renderCell: (params) => {
      return (
        <div className="cellWithStatus">
          {params.row.poids}
        </div>
      );
    },
  },
];

export const flightTrip = [
  {
    field: "numeroVol",
    headerClassName: "customHeader",
    headerName: "ID",
    width: 70,
    headerAlign: "center",
  },
  {
    field: "aeroportDepart",
    headerName: "From",
    width: 120,
    headerClassName: "customHeader",
    headerAlign: "center",
    renderCell: (params) => {
      return <div className="cellWithStatus">{params.row.aeroportDepart}</div>;
    },
  },
  {
    field: "aeroportDestination",
    headerName: "To",
    width: 120,
    headerClassName: "customHeader",
    headerAlign: "center",
    renderCell: (params) => {
      return <div className="cellWithStatus">{params.row.aeroportDestination}</div>;
    },
  },
  {
    field: "avion",
    headerName: "Airplane",
    width: 200,
    headerAlign: "center",
    headerClassName: "customHeader",
    renderCell: (params) => {
      return <div className="cellWithStatus">{params.row.avion.nomAvion}</div>;
    },
  },
  {
    field: "dateDepart",
    headerName: "Departure Date",
    width: 200,
    headerAlign: "center",
    headerClassName: "customHeader",
    renderCell: (params) => {
      return <div className="cellWithStatus">{params.row.dateDepart}</div>;
    },
  },
  {
    field: "dateArrivee",
    headerName: "Arrival Date",
    width: 200,
    headerAlign: "center",
    headerClassName: "customHeader",
    renderCell: (params) => {
      return <div className="cellWithStatus">{params.row.dateArrivee}</div>;
    },
  },
  {
    field: "etat",
    headerName: "Status",
    width: 160,
    headerClassName: "customHeader",
    headerAlign: "center",
    renderCell: (params) => {
      return <div className={`cellWithStatus ${params.row.etat}`}>{params.row.etat}</div>;
    },
  },
  {
    field: "nbPassagers",
    headerName: "Nb Passengers",
    width: 200,
    headerAlign: "center",
    headerClassName: "customHeader",
    renderCell: (params) => {
      return <div className="cellWithStatus">{params.row.nbPassagers}</div>;
    },
  },
  {
    field: "type",
    headerName: "Type",
    width: 200,
    headerAlign: "center",
    headerClassName: "customHeader",
    renderCell: (params) => {
      return <div className="cellWithStatus">{params.row.type}</div>;
    },
  },
];


