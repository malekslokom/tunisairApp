import "./single.scss";
import Sidebar from "../../components/sidebar/Sidebar";
import Navbar from "../../components/navbar/Navbar";
import {
  GoogleMap,
  Marker,
  useLoadScript,
  Polyline
} from "@react-google-maps/api";
import { useMemo } from "react";
import { FaPlane } from "react-icons/fa";
import { useLocation, useParams } from "react-router-dom";
import badge from "../../assets/images/badge.png";
import Button from "@mui/material/Button";
import { Link } from "react-router-dom";

const Single = () => {
  const location = useLocation();
  const searchParams = new URLSearchParams(location.search);
  const flightNumber = useParams().numeroVol;
  const from = searchParams.get("from");
  const to = searchParams.get("to");
  const depart = searchParams.get("depart");
  const arrive = searchParams.get("arrive");
  const etat = searchParams.get("etat");
  const type = searchParams.get("type");
  const weight = searchParams.get("poids");
  const user = JSON.parse(localStorage.getItem("user"));
  
  const isAdmin = user && user.role =="ROLE_ADMIN";
  const { isLoaded } = useLoadScript({
    googleMapsApiKey: process.env.REACT_APP_GOOGLE_API_KEY
  });

  const center = useMemo(() => ({ lat: 18.52043, lng: 73.856743 }), []);

  const flightPathCoordinates = useMemo(
    () => [
      { lat: 48.8566, lng: 2.3522, marker: `${from}` },
      { lat: 36.8065, lng: 10.1815, marker: `${to}` }
    ],
    []
  );

  return (
    <div className="single">
      <Sidebar />
      <div className="singleContainer">
        <div className="top">
          <div className="left">
            <h1 className="title">Flight Marchandise Details</h1>
            <div className="item">
              <img src={badge} alt="" className="itemImg" />
              <div className="details">
                <h1 className="itemTitle">Tunisaire</h1>
                <div className="detailItem">
                  <span className="itemKey">Flight Number:</span>
                  <span className="itemValue">{flightNumber}</span>
                </div>
                <div className="detailItem">
                  <span className="itemKey">From:</span>
                  <span className="itemValue">{from}</span>
                </div>
                <div className="detailItem">
                  <span className="itemKey">To:</span>
                  <span className="itemValue">{to}</span>
                </div>
                <div className="detailItem">
                  <span className="itemKey">Departure Time:</span>
                  <span className="itemValue">{depart}</span>
                </div>
                <div className="detailItem">
                  <span className="itemKey">Arrival Time:</span>
                  <span className="itemValue">{arrive}</span>
                </div>
                <div className="detailItem">
                  <span className="itemKey">Status:</span>
                  <span className="itemValue">{etat}</span>
                </div>
                {isAdmin && (
                    <>
                        <div className="detailItem">
                        <span className="itemKey">Type Merchandise:</span>
                        <span className="itemValue">{type}</span>
                        </div>
                        <div className="detailItem">
                        <span className="itemKey">Weight:</span>
                        <span className="itemValue">{weight}</span>
                        </div>
                        <Link
                        to={`/flights/editMR/${flightNumber}`}
                        style={{ textDecoration: "none" }}
                        className="link"
                        >
                        Edit Flight
                        </Link>
                    </>
                )}
              </div>
            </div>
          </div>
        </div>
        <div className="bottom">
          <h1 className="title">Flight Tracking</h1>
          <div className="App">
            {!isLoaded ? (
              <h1>Loading...</h1>
            ) : (
              <GoogleMap
                mapContainerClassName="map-container"
                center={center}
                zoom={2}
              >
                <Polyline
                  path={flightPathCoordinates.map((coordinate) => ({
                    lat: coordinate.lat,
                    lng: coordinate.lng
                  }))}
                  options={{
                    strokeColor: "#FF0000",
                    strokeOpacity: 1,
                    strokeWeight: 2,
                    icons: [
                      {
                        icon: new window.google.maps.MarkerImage(
                          <FaPlane />,
                          null,
                          null,
                          null,
                          new window.google.maps.Size(30, 30)
                        ),
                        offset: "100%"
                      }
                    ]
                  }}
                />
                {flightPathCoordinates.map((coordinate, index) => (
                  <Marker
                    key={`${coordinate.lat}-${coordinate.lng}`}
                    position={{ lat: coordinate.lat, lng: coordinate.lng }}
                    options={{
                      icon: {
                        url:
                          "https://maps.google.com/mapfiles/ms/icons/blue-dot.png",
                        scaledSize: new window.google.maps.Size(30, 30)
                      }
                    }}
                  />
                ))}
              </GoogleMap>
            )}
          </div>
        </div>
      </div>
    </div>
  );
};

export default Single;
