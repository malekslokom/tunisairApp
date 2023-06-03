import "./sidebar.scss";
import FlightIcon from "@mui/icons-material/Flight";
import PersonOutlineIcon from "@mui/icons-material/PersonOutline";
// import LocalShippingIcon from "@mui/icons-material/LocalShipping";
// import CreditCardIcon from "@mui/icons-material/CreditCard";
// import StoreIcon from "@mui/icons-material/Store";
import InsertChartIcon from "@mui/icons-material/InsertChart";
import SettingsApplicationsIcon from "@mui/icons-material/SettingsApplications";
import ExitToAppIcon from "@mui/icons-material/ExitToApp";
import SettingsSystemDaydreamOutlinedIcon from "@mui/icons-material/SettingsSystemDaydreamOutlined";
import PsychologyOutlinedIcon from "@mui/icons-material/PsychologyOutlined";
import AccountCircleOutlinedIcon from "@mui/icons-material/AccountCircleOutlined";
import { Link } from "react-router-dom";
import { DarkModeContext } from "../../context/darkModeContext";
import { useContext } from "react";
import Logo from "../../assets/images/Tunisair-logo.png"
const Sidebar = () => {
  const { dispatch } = useContext(DarkModeContext);
  const id = localStorage.getItem("user").id;
  const user = JSON.parse(localStorage.getItem("user"));
  
  const isAdmin = user && user.role =="ROLE_ADMIN";
  return (
    <div className="sidebar">
      <div className="top">
          <img src={Logo} className="Logo"/>
      </div>
      <hr />
      <div className="center">
        <ul>
          <p className="title">MAIN</p>
          {isAdmin ? (
  <>
    <Link to="/flights/mr" style={{ textDecoration: "none" }}>
      <li>
        <FlightIcon className="icon" />
        <span>List Flights Marchandise</span>
      </li>
    </Link>
    <Link to="/flights" style={{ textDecoration: "none" }}>
      <li>
        <FlightIcon className="icon" />
        <span>List Flights Trip</span>
      </li>
    </Link>
  </>
) : (
  <>
    <Link to="/flights/mr/user" style={{ textDecoration: "none" }}>
      <li>
        <FlightIcon className="icon" />
        <span>List Flights Marchandise</span>
      </li>
    </Link>
    <Link to="/flights/tr/user" style={{ textDecoration: "none" }}>
      <li>
        <FlightIcon className="icon" />
        <span>List Flights Trip</span>
      </li>
    </Link>
  </>
)}

          
          {isAdmin && (
            <>
            <p className="title">LISTS</p>

            <Link to="/users" style={{ textDecoration: "none" }}>
              <li>
                <PersonOutlineIcon className="icon" />
                <span>Employees</span>
              </li>
            </Link>
            </>
          )}
          <p className="title">USEFUL</p>
          <li>
            <InsertChartIcon className="icon" />
            <span>Stats</span>
          </li>
          <p className="title">SERVICE</p>
          <li>
            <SettingsSystemDaydreamOutlinedIcon className="icon" />
            <span>System Health</span>
          </li>
          <li>
            <PsychologyOutlinedIcon className="icon" />
            <span>Logs</span>
          </li>
          <li>
            <SettingsApplicationsIcon className="icon" />
            <span>Settings</span>
          </li>
          <p className="title">USER</p>
          <Link to={`/users/${id}`} style={{ textDecoration: "none" }}>
          <li>
            <AccountCircleOutlinedIcon className="icon" />
            <span>Profile</span>
          </li>
          </Link>
          <li>
            <ExitToAppIcon className="icon" />
            <span>Logout</span>
          </li>
        </ul>
      </div>
      {/* <div className="bottom">
        <div
          className="colorOption"
          onClick={() => dispatch({ type: "LIGHT" })}
        ></div>
        <div
          className="colorOption"
          onClick={() => dispatch({ type: "DARK" })}
        ></div>
      </div> */}
    </div>
  );
};

export default Sidebar;
