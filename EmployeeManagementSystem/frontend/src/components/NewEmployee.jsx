import React from 'react';
import { useNavigate } from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

function NewEmployee (props) {
  
  const navigate = useNavigate();
  
  function handleSubmit (event) {
    event.preventDefault();
    const fname = event.target[0].value;
    const lname = event.target[1].value;
    EmployeeService.createNewEmployee(fname, lname);
    navigate('/');
  }
  
  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label title="First name of the employee" htmlFor="first-name">First
          Name:</label>
        <input id="first-name" type="text"/>
      </div>
      <br/>
      <div>
        <label title="Last name of the employee" htmlFor="last-name">Last
          Name:</label>
        <input id="last-name" type="text"/>
      </div>
      <button type="submit" className="btn btn-primary">Add</button>
    </form>
  );
}

export default NewEmployee;
