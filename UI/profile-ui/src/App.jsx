import {
  ProfileList,
  ProfileRegistration,
} from "./components/ProfileMangement";
import { Link, Routes, Route } from "react-router-dom";
// This is the root component, all other components goes here
function App() {
  return (
    <div>
      <h2 className="alert alert-primary text-center">
        Profile Management App
      </h2>
      <Link to="/register">Register</Link> ||
      <Link to="/findAll">Profile List</Link> ||
      <Link to="/login">Login</Link> ||
      <Link to="/about">About Us</Link> <hr />
      <div className="container">
        <Routes>
          <Route path="" element={<ProfileRegistration />}></Route>
          <Route path="/register" element={<ProfileRegistration />}></Route>
          <Route path="/findAll" element={<ProfileList />}></Route>
          <Route
            path="/login"
            element={<div>Login is an activity</div>}
          ></Route>
          <Route
            path="/about"
            element={<div>About us is an activity</div>}
          ></Route>
        </Routes>
      </div>
    </div>
  );
}

// App is imported in main.jsx file
export default App;
