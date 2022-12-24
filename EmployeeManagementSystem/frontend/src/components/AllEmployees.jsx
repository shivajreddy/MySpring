import React, { useEffect } from 'react';
import EmployeeService from '../services/EmployeeService';
import NewEmployee from './NewEmployee';
import { Link, useNavigate } from 'react-router-dom';
import nav from './Nav';

function AllEmployees (props) {
  
  const navigate = useNavigate();
  
  const [allEmployees, setAllEmployees] = React.useState([]);
  
  useEffect(() => {
    EmployeeService.getEmployees().then((res) => {
      setAllEmployees(res.data);
    });
  }, [allEmployees]);
  
  
  function deleteAllRows (event) {
    EmployeeService.deleteAllEmployees().then((res) => {
      if (res.status === 200) {
        setAllEmployees([]);
      }
    });
  }
  
  function removeEmployee (id) {
    console.log("runnign removeEmployee for", id);
    EmployeeService.deleteEmployeeById(id);
    // navigate('/');
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
                      <button
                        onClick={() => navigate(
                          `/update/${employee.id}`)}>update
                      </button>
                      <button onClick={()=>removeEmployee(employee.id)}>remove</button>
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