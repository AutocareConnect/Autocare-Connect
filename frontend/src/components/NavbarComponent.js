// src/components/NavbarComponent.js
import React, { useState } from 'react';
import { Navbar, NavbarBrand, Nav, NavItem, NavLink as ReactNavLink, Dropdown, DropdownToggle, DropdownMenu, DropdownItem } from 'reactstrap';
import { NavLink } from 'react-router-dom';

const NavbarComponent = () => {
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const toggleDropdown = () => setDropdownOpen(prevState => !prevState);

  return (
    <Navbar color="dark" dark expand="md">
      <NavbarBrand href="/">
        <img alt="logo" src="assets/logo.png" style={{ height: 40, width: 40 }} />
        Autocare Connect
      </NavbarBrand>
      <Nav className="ml-auto" navbar>
        <NavItem>
          <ReactNavLink tag={NavLink} to="/">Home</ReactNavLink>
        </NavItem>
        <NavItem>
          <ReactNavLink href="#solution">Solution</ReactNavLink>
        </NavItem>
        <NavItem>
          <ReactNavLink href="#services">Services</ReactNavLink>
        </NavItem>
        <NavItem>
          <ReactNavLink href="#contact">Contact Us</ReactNavLink>
        </NavItem>
        <NavItem>
          <ReactNavLink tag={NavLink} to="/login">Login</ReactNavLink>
        </NavItem>
        <NavItem>
          <Dropdown isOpen={dropdownOpen} toggle={toggleDropdown} nav inNavbar>
            <DropdownToggle nav caret>
              Register
            </DropdownToggle>
            <DropdownMenu right>
              <DropdownItem tag={NavLink} to="/register/user">User</DropdownItem>
              <DropdownItem tag={NavLink} to="/register/service-centre">Service Centre</DropdownItem>
            </DropdownMenu>
          </Dropdown>
        </NavItem>
      </Nav>
    </Navbar>
  );
};

export default NavbarComponent;
