// two exports we have in javascript
// default exports - import Name from 'path'
// named exprots - import {Name1, Name2} from 'path'
// importing default & named import Name, {Name1, Name2} from 'path';

import { useState } from "react";
import axios from "axios"; // axios is a default module

// Fetch All profiles
export function ProfileList() {
  let [profiles, setProfiles] = useState(undefined);
  let handleClick = (event) => {
    let URL = "http://localhost:9090/api/v2/profiles";
    axios
      .get(URL)
      .then((s) => setProfiles(s.data))
      .catch((e) => console.log(e));
  };
  return (
    <div className="container-fluid">
      <button onClick={handleClick} className="btn btn-primary btn-lg">
        Refresh
      </button>
      <div>
        <table className="table">
          <thead>
            <tr>
              <th>Sl. No</th>
              <th>Id</th>
              <th>Name</th>
              <th>Phone</th>
              <th>Birthday</th>
            </tr>
          </thead>
          <tbody>
            {profiles?.map((value, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{value.profileId}</td>
                <td>{value.name}</td>
                <td>{value.phone}</td>
                <td>{value.dob}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}

// Registration component - named export
export function ProfileRegistration() {
  let [name, setName] = useState("");
  let [password, setPassword] = useState("");
  let [phone, setPhone] = useState("");
  let [dob, setDob] = useState("");
  let [message, setMessage] = useState(""); // to show the message after form-submission
  let handleSubmit = (event) => {
    event.preventDefault(); // prevents reload of the browser
    // HTTP POST request axios.post(url, body).then(callback).catch(callback)

    let store_url = "http://localhost:9090/api/v2/profiles";
    // axios.post("").then("").catch("")
    axios
      .post(store_url, {
        name: name,
        password: password,
        dob: dob,
        phone: phone,
      })
      .then((s) => {
        setMessage("Profile Registered with an id: " + s.data.profileId);
        setName("");
        setPassword("");
        setPhone("");
        setDob("");
      })
      .catch((e) => console.log(e));

    // printing the states after submitting to ensure states are initialized to submit
    // console.log(name, password, phone, dob, message);
    // alert("Form submission is pending....");
  };
  return (
    <div className="container-fluid">
      <div className="w-25">
        <h3 className="alert alert-primary text-center">
          Profile Registration
        </h3>
        <hr />
        <h4 className="text-success">{message}</h4>
        <form onSubmit={handleSubmit}>
          <label>Enter Name</label>
          <input
            type="text"
            value={name}
            onChange={(event) => setName(event.target.value)}
            className="form-control form-control-lg"
          ></input>
          <br />
          <label>Enter Password</label>
          <input
            type="password"
            value={password}
            className="form-control form-control-lg"
            onChange={(event) => setPassword(event.target.value)}
          ></input>
          <br />
          <label>Enter Phone</label>
          <input
            type="number"
            value={phone}
            className="form-control form-control-lg"
            onChange={(event) => setPhone(event.target.value)}
          ></input>
          <br />
          <label>Select Birthday</label>
          <input
            type="date"
            value={dob}
            className="form-control form-control-lg"
            onChange={(event) => setDob(event.target.value)}
          ></input>
          <br />

          <input
            type="submit"
            value="Register"
            className="btn btn-primary btn-lg w-100"
          ></input>
        </form>
      </div>
    </div>
  );
}
