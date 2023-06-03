// ** React Imports
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import React, { useState, useEffect } from "react";
import "./new.scss";
import logo from "../../assets/images/logo-tab.png";
import { DemoContainer } from "@mui/x-date-pickers/internals/demo";
import { AdapterDayjs } from "@mui/x-date-pickers/AdapterDayjs";
import { LocalizationProvider } from "@mui/x-date-pickers/LocalizationProvider";
import { DateTimePicker } from "@mui/x-date-pickers/DateTimePicker";
// ** MUI Imports
import Card from "@mui/material/Card";
import Grid from "@mui/material/Grid";
import Button from "@mui/material/Button";
import Divider from "@mui/material/Divider";
import TextField from "@mui/material/TextField";
import CardHeader from "@mui/material/CardHeader";
import Typography from "@mui/material/Typography";
import CardContent from "@mui/material/CardContent";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import InputLabel from "@mui/material/InputLabel";
import { useLocation, useParams } from "react-router-dom";

const New = () => {
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);

  const flightNumber = useParams().flightNumber;
  console.log(flightNumber)
  //token
  const [token, setToken] = useState("");
  // staff
  const [selectStaff, setSelectStaff] = useState([]);
  const [staff, setStaff] = useState([]);

  const [numeroVol, setNumeroVol] = useState(flightNumber);

  //pilots
  const [selectPilot, setSelectPilot] = useState({});
  const [pilots, setPilots] = useState([]);

  //copilots
  const [selectCopilot, setSelectCopilot] = useState({});
  const [copilots, setCopilots] = useState([]);

  //status
  const [flight, setFlight] = useState({});
  const [status, setStatus] = useState("");

  //delay
  const [delay, setDelay] = useState("");

  // airplanes
  const [selectAirplane, setSelectAirplane] = useState([]);
  const [airplanes, setAirplanes] = useState([]);

  // departure
  const [selecteDepartTime, setSelecteDepartTime] = useState([]);
  const [selecteArrivalTime, setSelectArrivalTime] = useState([]);

  // aerports
  const [to, setTo] = useState({});
  const [from, setFrom] = useState({});
  const [listAeroprts, setListAeroprts] = useState([]);

  // weight
  const [weight, setWeight] = useState(0);

  // type marchandise
  const [typeMarchandise, setTypeMarchandise] = useState("");

  // equipage
  const [idEquipage, setIdEquipage] = useState("");

  // restaurants
  const [selectRestaurant, setSelectRestaurant] = useState([]);
  const [restaurants, setRestaurants] = useState([]);

  // vol
  // arrival
  const inputStyle = {
    width: 750,
    backgroundColor: ""
  };

  useEffect(() => {
    let token = localStorage.getItem("token");
    setToken(token);
    getRestaurants(token);
    getPilots(token);
    getCopilots(token);
    getAirplanes(token);
    getStaff(token);
    getAeroports(token);
    getFlight(token);
  }, []);

  // get Flights

  // get restaurants
  const getRestaurants = async (token) => {
    fetch("http://192.168.1.8:8090/api/restaurations", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    })
      .then((response) => response.json())
      .then((data) => {
        setRestaurants(data);
      })
      .catch((error) => {
        console.error("Error fetching restaurants:", error);
      });
  };

  // get aeroports
  const getAeroports = async (token) => {
    fetch("http://192.168.1.8:8090/api/aeroports", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    })
      .then((response) => response.json())
      .then((data) => {
        setListAeroprts(data);
      })
      .catch((error) => {
        console.error("Error fetching aeroports:", error);
      });
  };
  // get pilots
  const getPilots = async (token) => {
    fetch("http://192.168.1.8:8090/api/pilotes", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    })
      .then((response) => response.json())
      .then((data) => {
        setPilots(data);
      })
      .catch((error) => {
        console.error("Error fetching pilots:", error);
      });
  };

  // get copilots
  const getCopilots = async (token) => {
    fetch("http://192.168.1.8:8090/api/copilotes", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    })
      .then((response) => response.json())
      .then((data) => {
        setCopilots(data);
      })
      .catch((error) => {
        console.error("Error fetching copilots:", error);
      });
  };

  // get staff
  const getStaff = async (token) => {
    fetch("http://192.168.1.8:8090/api/staff", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    })
      .then((response) => response.json())
      .then((data) => {
        setStaff(data);
      })
      .catch((error) => {
        console.error("Error fetching staff:", error);
      });
  };

  // get airplanes
  const getAirplanes = async (token) => {
    fetch("http://192.168.1.8:8090/api/avions", {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    })
      .then((response) => response.json())
      .then((data) => {
        setAirplanes(data);
      })
      .catch((error) => {
        console.error("Error fetching airplanes:", error);
      });
  };
  const updateEquipage = () => {
    return new Promise((resolve, reject) => {
      let token = localStorage.getItem("token");
      const equipage = {
        copilot: selectCopilot,
        pilot: selectPilot,
        staff: selectStaff
      };
      console.log('equipage ', equipage)
      fetch(`http://192.168.1.8:8090/api/equipages/${idEquipage}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${token}`
        },
        body: JSON.stringify(equipage)
      })
        .then((response) => response.json())
        .then((data) => {
          console.log("Equipage saved:", data);
          resolve(data);
        })
        .catch((error) => {
          console.error("Error saving equipage:", error);
          reject(error);
        });
    });
  };

  const updateFlight = () => {
    let token = localStorage.getItem("token");
    updateEquipage()
      .then((equipage) => {
        let flight = {
          dateDepart: selecteDepartTime,
          dateArrivee: selecteArrivalTime,
          retard: delay,
          etat: status,
          aeroportDepart: { idAeroport: from },
          aeroportDestination: { idAeroport: to },
          avion: { idAvion: selectAirplane },
          equipage: { idEquipage: equipage.idEquipage },
          restaurations: selectRestaurant.map(({ idRestauration }) => ({
            idRestauration
          })),
          typeMarchandise,
          poids: weight
        };

        console.log(JSON.stringify(flight));

        fetch(`http://192.168.1.8:8090/api/volMarchandises/${numeroVol}`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`
          },
          body: JSON.stringify(flight)
        })
          .then((response) => response.json())
          .then((data) => {

            console.log("Flight update:", data);
            setFlight(data);
          })
          .catch((error) => {
            console.error("Error saving flight:", error);
          });
      })
      .catch((error) => {
        console.error("Error saving equipage:", error);
      });
  };

  const getFlight = async (token) => {
    console.log('flight  ', flightNumber)
    fetch(`http://192.168.1.8:8090/api/volMarchandises/${flightNumber}`, {
      method: "GET",
      headers: {
        "Content-Type": "application/json",
        Authorization: `Bearer ${token}`
      }
    })
      .then((response) => response.json())
      .then((data) => {
        console.log('data here edit mr ', data)
        const equipageId = data?.equipage?.idEquipage;
        console.log('esuipage ', equipageId)
        setIdEquipage(equipageId);
        setFlight(data);
      })
      .catch((error) => {
        console.error("Error fetching aeroports:", error);
      });
  };

  return (
    <div className="new">
      <Sidebar />
      <div className="newContainer">
        <Navbar />

        <div
          style={{
            position: "absolute",
            top: "560px",
            left: "50%",
            transform: "translate(-50%, -50%)"
          }}
        >
          <Card style={inputStyle}>
            <CardHeader
              title="Edit Flight Marchandise"
              titleTypographyProps={{ variant: "h4" }}
            >
              <img src={logo} alt="Avatar" width={10} />
            </CardHeader>
            <Divider sx={{ margin: 0 }} />
            <form onSubmit={(e) => e.preventDefault()}>
              <CardContent>
                <Grid container spacing={2}>
                  <Grid item xs={12}>
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>
                      Flight
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <TextField
                      fullWidth
                      type="number"
                      label="Flight code"
                      placeholder="XX123"
                      value={numeroVol}
                    />
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Select Airplane
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        label="Select Airplane"
                        value={selectAirplane}
                        onChange={(event) =>
                          setSelectAirplane(event.target.value)
                        }
                      >
                        {airplanes.map((airplane) => (
                          <MenuItem
                            key={airplane.idAvion}
                            value={airplane.idAvion}
                          >
                            {airplane.nomAvion}
                          </MenuItem>
                        ))}
                      </Select>
                    </FormControl>
                  </Grid>
                  <Grid item xs={12}>
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>
                      Aeroport
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Flying From
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        value={from}
                        onChange={(event) => setFrom(event.target.value)}
                        label="Flying From"
                      >
                        {listAeroprts.map((aeroport) => (
                          <MenuItem
                            key={aeroport.idAeroport}
                            value={aeroport.idAeroport}
                          >
                            {aeroport.nom}
                          </MenuItem>
                        ))}
                      </Select>
                    </FormControl>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Flying To
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        value={to}
                        onChange={(event) => setTo(event.target.value)}
                        label="Flying To"
                      >
                        {listAeroprts.map((aeroport) => (
                          <MenuItem
                            key={aeroport.idAeroport}
                            value={aeroport.idAeroport}
                          >
                            {aeroport.nom}
                          </MenuItem>
                        ))}
                      </Select>
                    </FormControl>
                  </Grid>
                  <Grid item xs={12}>
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>
                      Schedule
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                      <DemoContainer components={["DateTimePicker"]}>
                        <DateTimePicker
                          value={selecteDepartTime}
                          onChange={setSelecteDepartTime}
                          label="Departure Date and Time"
                        />
                      </DemoContainer>
                    </LocalizationProvider>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <LocalizationProvider dateAdapter={AdapterDayjs}>
                      <DemoContainer components={["DateTimePicker"]}>
                        <DateTimePicker
                          value={selecteArrivalTime}
                          onChange={setSelectArrivalTime}
                          label="Arrival Date and Time"
                        />
                      </DemoContainer>
                    </LocalizationProvider>
                  </Grid>
                  <Grid item xs={12}>
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>
                      Restaurant
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Select a restaurant
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        value={selectRestaurant}
                        label="Select a restaurant"
                        onChange={(event) =>
                          setSelectRestaurant(event.target.value)
                        }
                        multiple
                      >
                        {restaurants.map((restaurant) => (
                          <MenuItem
                            key={restaurant.idRestauration}
                            value={restaurant.idRestauration}
                          >
                            {restaurant.nom}
                          </MenuItem>
                        ))}
                      </Select>
                    </FormControl>
                  </Grid>
                  <Grid item xs={12}>
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>
                      Delay
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <TextField
                      fullWidth
                      type="number"
                      label="Delay"
                      placeholder="Enter the delay"
                      value={delay}
                      onChange={(event) => setDelay(event.target.value)}
                    />
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Select flight status
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        value={status}
                        label="Select flight status"
                        onChange={(event) => setStatus(event.target.value)}
                      >
                        <MenuItem value="onTime">On time</MenuItem>
                        <MenuItem value="delayed">Delayed</MenuItem>
                        <MenuItem value="cancelled">Cancelled</MenuItem>
                      </Select>
                    </FormControl>
                  </Grid>
                  <Grid item xs={12}>
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>
                      Team
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Select pilot
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        value={selectPilot}
                        label="Select pilot"
                        onChange={(event) => setSelectPilot(event.target.value)}
                      >
                        {pilots.map((pilot) => (
                          <MenuItem
                            key={pilot.idEmploye}
                            value={pilot.idEmploye}
                          >
                            {pilot.nom} {pilot.prenom}
                          </MenuItem>
                        ))}
                      </Select>
                    </FormControl>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Select co-pilot
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        value={selectCopilot}
                        onChange={(event) =>
                          setSelectCopilot(event.target.value)
                        }
                        label="Select co-pilot"
                      >
                        {copilots.map((copilot) => (
                          <MenuItem
                            key={copilot.idEmploye}
                            value={copilot.idEmploye}
                          >
                            {copilot.nom} {copilot.prenom}
                          </MenuItem>
                        ))}
                      </Select>
                    </FormControl>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <FormControl fullWidth>
                      <InputLabel id="form-layouts-separator-select-label">
                        Select personnel
                      </InputLabel>
                      <Select
                        id="form-layouts-separator-select"
                        labelId="form-layouts-separator-select-label"
                        value={selectStaff}
                        onChange={(event) => setSelectStaff(event.target.value)}
                        multiple
                        label="Select personnel"
                      >
                        {staff.map((member) => (
                          <MenuItem
                            key={member.idEmploye}
                            value={member.idEmploye}
                          >
                            {member.nom} {member.prenom}
                          </MenuItem>
                        ))}
                      </Select>
                    </FormControl>
                  </Grid>

                  <Grid item xs={12}>
                    <Typography variant="body2" sx={{ fontWeight: 600 }}>
                      Marchandise
                    </Typography>
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <TextField
                      fullWidth
                      type="number"
                      label="Weight"
                      placeholder="0"
                      value={weight}
                      onChange={(event) => setWeight(event.target.value)}
                    />
                  </Grid>
                  <Grid item xs={12} sm={6}>
                    <TextField
                      fullWidth
                      type="text"
                      label="Type merchandise"
                      placeholder="Select type merchandise"
                      value={typeMarchandise}
                      onChange={(event) =>
                        setTypeMarchandise(event.target.value)
                      }
                    />
                  </Grid>
                </Grid>
                <div style={{ display: "flex", justifyContent: "center" }}>
                  <Button
                    size="large"
                    type="submit"
                    sx={{ mr: 3 }}
                    variant="contained"
                    style={{
                      backgroundColor: "rgba(235,31,40,255)",
                      top: "30px"
                    }}
                    onClick={updateFlight}
                  >
                    Update
                  </Button>
                  <Button
                    size="large"
                    color="secondary"
                    variant="outlined"
                    style={{
                      color: "rgba(235,31,40,255)",
                      borderColor: "rgba(235,31,40,255)",
                      top: "30px"
                    }}
                  >
                    Cancel
                  </Button>
                </div>
              </CardContent>
            </form>
          </Card>
        </div>
      </div>
    </div>
  );
};

export default New;
