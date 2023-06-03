import Welcome from "./pages/welcome/welcome";
import Login from "./pages/login/Login";
import Register from "./pages/register/register";

import FlightsTR from "./pages/flights/FlightsTR";
import FlightsMR from "./pages/flights/FlightsMR";
import FlightsMRuser from "./pages/flights/FlightsMRuser";
import FlightsTRuser from "./pages/flights/FlightsTRuser";


import SingleMR from "./pages/single/SingleMR";
import SingleTR from "./pages/single/SingleTR";

import EditMR from "./pages/new/EditMR";
import EditTR from "./pages/new/EditTR";

import NewMR from "./pages/new/NewMR";
import NewTR from "./pages/new/NewTR";

import { BrowserRouter, Routes, Route } from "react-router-dom";
import "./style/dark.scss";
import { useContext } from "react";
import { DarkModeContext } from "./context/darkModeContext";
import List from "./pages/list/List";

//import Home from "./pages/home/Home";

function App() {
  const { darkMode } = useContext(DarkModeContext);

  return (
    <div className={darkMode ? "app dark" : "app"}>
      <BrowserRouter>
        <Routes>
          <Route path="/">
            <Route index element={<Welcome />} />
            <Route path="signin" element={<Login />} />
            <Route path="signin" element={<Login />} />
            {/* <Route path="/home" element={<Home />} /> */}
            <Route path="signup" element={<Register />} />
            <Route path="users" element={<List />} />
            <Route path="flights" element={<FlightsTR />} />
            <Route path="flights/mr" element={<FlightsMR />} />
            <Route path="flights/newTR" element={<NewTR/>}/>
            <Route path="flights/newMR" element={<NewMR/>}/>
            <Route path="flights/editTR/:flightNumber" element={<EditTR/>}/>
            <Route path="flights/editMR/:flightNumber" element={<EditMR/>}/>
            <Route path="flights/detail/tr/:numeroVol" element={<SingleTR/>}/>
            <Route path="flights/detail/mr/:numeroVol" element={<SingleMR/>}/>


            <Route path="flights/tr/user" element={<FlightsTRuser />} />
            <Route path="flights/mr/user" element={<FlightsMRuser />} />
            </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
