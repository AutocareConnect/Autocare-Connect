import React, { useState } from 'react';
import { Navbar, NavbarBrand, Nav, NavItem, NavLink, Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { Link } from 'react-router-dom';

const NavbarComponent = () => {
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const toggleDropdown = () => setDropdownOpen(prevState => !prevState);

  return (
    <Navbar color="dark" dark expand="md">
      <NavbarBrand href="/">
        <img alt="logo" src="assets/logo.png" style={{ height: 40, width: 40 }} />
        Autocare
      </NavbarBrand>
      <Nav className="ml-auto" navbar>
        <NavItem>
          <NavLink href="/">Home</NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="#solution">Solution</NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="#services">Services</NavLink>
        </NavItem>
        <NavItem>
          <NavLink href="#contact">Contact Us</NavLink>
        </NavItem>
        <NavItem>
          <Dropdown isOpen={dropdownOpen} toggle={toggleDropdown} nav inNavbar>
            <DropdownToggle nav caret>
              Login
            </DropdownToggle>
            <DropdownMenu right>
              <DropdownItem tag={Link} to="/login/admin">Admin</DropdownItem>
              <DropdownItem tag={Link} to="/login/user">User</DropdownItem>
              <DropdownItem tag={Link} to="/login/service-centre">Service Centre</DropdownItem>
            </DropdownMenu>
          </Dropdown>
        </NavItem>
        <NavItem>
          <NavLink href="#register">Register</NavLink>
        </NavItem>
      </Nav>
    </Navbar>
  );
};

export default NavbarComponent;
