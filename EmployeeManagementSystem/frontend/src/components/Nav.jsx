import React from 'react';
import { Link } from 'react-router-dom';

function Nav (props) {
  return (
    <div style={{ backgroundColor: 'black', textDecoration: 'none' }}>
      <Link to="/"> Home </Link>
    </div>
  );
}

export default Nav;
