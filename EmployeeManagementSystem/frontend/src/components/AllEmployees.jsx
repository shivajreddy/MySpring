import React, { useEffect } from 'react';
import EmployeeService from '../services/EmployeeService';
import NewEmployee from './NewEmployee';
import { Link } from 'react-router-dom';

function AllEmployees () {
  
  const [allEmployees, setAllEmployees] = React.useState([]);
  
  useEffect(() => {
    EmployeeService.getEmployees().then((res) => {
      setAllEmployees(res.data);
    });
  }, []);
  
  // console.log('all employees = ', allEmployees);
  
  function deleteAllRows (event) {
    EmployeeService.deleteAllEmployees().then((res) => {
      // console.log('this is the deleteAllRows result', res);
      if (res.status === 200) {
        setAllEmployees([]);
      }
    });
  }
  
  function updateEmployee (event) {
    console.log('here are the user details');
    console.log(event.target);
    const element = event.target;
    // EmployeeService.updateEmployee();
    
  }
  
  function removeEmployee (event) {
  }
  
  return (
    <div>
      
      <h2>All employees</h2>
      
      <div>
        <h2 className="text-center">Employees list</h2>
        <div className="row">
          <table className="table table-striped table-bordered">
            
            
            <thead>
            <tr>
              <th>Employee First Name</th>
              <th>Employee Last Name</th>
              <th>Employee Email</th>
              <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            {
              allEmployees.map(
                employee =>
                  <tr key={employee.id} id={employee.id}>
                    <td>{employee.firstName}</td>
                    <td>{employee.lastName}</td>
                    <td>{employee.email}</td>
                    <td>
                      <button onClick={updateEmployee}>update</button>
                      <button onClick={removeEmployee}>remove</button>
                    </td>
                  </tr>,
              )
            }
            </tbody>
          </table>
        </div>
      </div>
      
      <Link className="btn btn-primary" to="/new" element={<NewEmployee/>}>Add
        new</Link>
      
      <button onClick={deleteAllRows} className="btn btn-danger">delete all
      </button>
    
    </div>
  );
  
}

export default AllEmployees;