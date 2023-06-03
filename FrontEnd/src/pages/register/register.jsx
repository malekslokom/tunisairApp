import { useState } from "react";
import SignUp from "./../../components/Auth/SignUp/SignUp";
import signImage from "../../assets/images/sign.jpg";
import { useNavigate } from "react-router-dom";

const Register = () => {
  let navigate = useNavigate();

  const [values, setValues] = useState({
    username: "",
    email: "",
    password: "",
    confirmPassword: "",
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
      id: 2,
      name: "email",
      type: "email",
      placeholder: "Email",
      errorMessage: "It should be a valid email address!",
      label: "Email",
      required: true,
    },
    {
      id: 4,
      name: "password",
      type: "password",
      placeholder: "Password",
      errorMessage:
        "Password should be 8 characters or longer!",
      label: "Password",
      pattern: `^.{8,}$`,
      required: true,
    },    
    {
      id: 5,
      name: "confirmPassword",
      type: "password",
      placeholder: "Confirm Password",
      errorMessage: "Passwords don't match!",
      label: "Confirm Password",
      pattern: values.password,
      required: true,
    },
  ];

  const handleSubmit = (e) => {
    e.preventDefault();
  };

  const onChange = (e) => {
    setValues({ ...values, [e.target.name]: e.target.value });
  };
  const signup = () => {
    const payload ={
      email: values.email,
      username:values.username,
      password: values.password
    }
    console.log('here')
    fetch('http://192.168.1.8:8090/api/auth/signup', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(payload),
    })
      .then((response) => response.json())
      .then((data) => {
        navigate('/signin');
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
        <h1 style={{ color: "rgb(238,61,71)", textAlign: "center" }}>Register</h1>
        {inputs.map((input) => (
          <SignUp
            key={input.id}
            {...input}
            value={values[input.name]}
            onChange={onChange}
          />
        ))}
        <button
          onClick={signup}
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
export default Register;