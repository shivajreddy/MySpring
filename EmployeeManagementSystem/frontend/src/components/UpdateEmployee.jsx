import React, { useEffect } from 'react';
import EmployeeService from '../services/EmployeeService';
import { useNavigate } from 'react-router-dom';

function UpdateEmployee (props) {
  
  const navigate = useNavigate();
  
  // get the id from url
  const url = window.location.href;
  const id = parseInt(url.split('/')[4]);
  
  const [firstName, setFirstName] = React.useState("");
  const [lastName, setLastName] = React.useState("");
  
  useEffect(() => {
    EmployeeService.getEmployeeById(id).then((res) => {
        setFirstName(res.data.firstName);
        setLastName(res.data.lastName);
      },
    );
  }, [id]);
  
  function updateEmployee (event) {
    event.preventDefault();
    EmployeeService.updateEmployee(id, firstName, lastName);
    navigate('/')
  }
  
  const changeFirstName = (event) => {
    setFirstName(event.target.value);
  };
  
  const changeLastName = (event) => {
    setLastName(event.target.value);
  };
  
  return (
    <form onSubmit={updateEmployee}>
      <div>
        <label title="First name of the employee" htmlFor="first-name">First
          Name:</label>
        <input id="first-name" type="text" value={firstName}
               onChange={changeFirstName}/>
      </div>
      <br/>
      <div>
        <label title="Last name of the employee" htmlFor="last-name">Last
          Name:</label>
        <input id="last-name" type="text" value={lastName}
               onChange={changeLastName}/>
      </div>
      <button type="submit" className="btn btn-primary">Update</button>
    </form>
  );
}

export default UpdateEmployee;
