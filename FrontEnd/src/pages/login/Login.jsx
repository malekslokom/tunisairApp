import { useState } from "react";
import SignIn from "./../../components/Auth/SignIn/SignIn";
import signImage from "../../assets/images/sign.jpg";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const navigate = useNavigate();

  const [values, setValues] = useState({
    username: "",
    password: "",
  });

  const inputs = [
    {
      id: 1,
      name: "username",
      type: "text",
      placeholder: "Username",
      errorMessage:
        "Username should be 3-16 characters and shouldn't include any special character!",
      label: "Username",
      pattern: "^[A-Za-z0-9]{3,16}$",
      required: true,
    },
    {
      id: 4,
      name: "password",
      type: "password",
      placeholder: "Password",
      errorMessage: "Password should be 8 characters or longer!",
      label: "Password",
      pattern: `^.{4,}$`,
      required: true,
    },
  ];

  const handleSubmit = (e) => {
    e.preventDefault();
  };

  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };

  const signin = () => {
    fetch('http://192.168.1.8:8090/api/auth/signin', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(values),
    })
      .then((response) => response.json())
      .then((data) => {
        console.log(data)
        const { accessToken, email, username, roles } = data;
        // Save the token, email, and username in localStorage
        localStorage.setItem('token', accessToken);
        const user = {
          email,
          username,
          role:roles[0],
        };
        localStorage.setItem('user', JSON.stringify(user));
        if(user.role == "ROLE_USER"){
          navigate('/flights/mr/user');

        } else {
          navigate('/flights');
        }
      })
      .catch((error) => {
        // Handle the error
        console.error('Error:', error);
      });
  };

  return (
    <div
      className="signin"
      style={{
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        height: "100vh",
        background: `linear-gradient(rgba(255, 255, 255, 0.7), rgba(255, 255, 255, 0.3)), url(${signImage})`,
        backgroundSize: "cover",
        backgroundPosition: "center",
      }}
    >
      <form
        onSubmit={handleSubmit}
        style={{
          backgroundColor: "white",
          padding: "0px 60px",
          borderRadius: "10px",
        }}
      >
        <h1 style={{ color: "rgb(238,61,71)", textAlign: "center" }}>Login</h1>
        {inputs.map((input) => (
          <SignIn
            key={input.id}
            {...input}
            value={values[input.name]}
            onChange={onChange}
          />
        ))}
        <button
          onClick={signin}
          style={{
            width: "100%",
            height: "50px",
            padding: "10px",
            border: "none",
            backgroundColor: "rgb(238,61,71)",
            color: "white",
            borderRadius: "5px",
            fontWeight: "bold",
            fontSize: "18px",
            cursor: "pointer",
            marginTop: "15px",
            marginBottom: "30px",
          }}
        >
          Submit
        </button>
      </form>
    </div>
  );
};

export default Login;
