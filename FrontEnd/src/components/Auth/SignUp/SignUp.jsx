import React, { useState } from "react";
import styled from "styled-components";

const FormInput = styled.div`
  display: flex;
  flex-direction: column;
  width: 280px;

  label {
    font-size: 12px;
    color: gray;
  }

  input {
    padding: 15px;
    margin: 10px 0px;
    border-radius: 5px;
    border: 1px solid gray;
  }

  span {
    font-size: 12px;
    padding: 3px;
    color: red;
    display: none;
  }

  input:invalid[focused="true"] {
    border: 1px solid red;
  }

  input:invalid[focused="true"] ~ span {
    display: block;
  }
`;

const SignUp = (props) => {
  const [focused, setFocused] = useState(false);
  const { label, errorMessage, onChange, id, ...inputProps } = props;

  const handleFocus = (e) => {
    setFocused(true);
  };

  return (
    <FormInput>
      <label>{label}</label>
      <input
        {...inputProps}
        onChange={onChange}
        onBlur={handleFocus}
        onFocus={() => inputProps.name === "confirmPassword" && setFocused(true)}
        focused={focused.toString()}
      />
      <span>{errorMessage}</span>
    </FormInput>
  );
};

export default SignUp;
