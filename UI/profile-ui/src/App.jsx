import {
  ProfileList,
  ProfileRegistration,
} from "./components/ProfileMangement";
// This is the root component, all other components goes here
function App() {
  return (
    <div>
      <h2 className="alert alert-primary text-center">
        Profile Management App
      </h2>
      <ProfileList />
      <ProfileRegistration />
    </div>
  );
}

// App is imported in main.jsx file
export default App;
