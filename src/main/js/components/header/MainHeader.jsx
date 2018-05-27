import React, {Component} from 'react';
import Navbar from 'react-bootstrap/lib/Navbar';
import {Link} from 'react-router-dom';

class MainHeader extends Component {
    render() {
        return (
            <Navbar>
                <Navbar.Header>
                    <Navbar.Brand>
                        <Link to='/'>
                            Home
                        </Link>
                    </Navbar.Brand>
                    <Navbar.Brand>
                        <Link to='/portal'>
                            Portal
                        </Link>
                    </Navbar.Brand>
                    <Navbar.Brand>
                        <Link to='/admin'>
                            Admin
                        </Link>
                    </Navbar.Brand>
                    <Navbar.Brand>
                        <Link to='/login'>
                            Login
                        </Link>
                    </Navbar.Brand>
                    <Navbar.Brand>
                        <a href="/logout">
                            Logout
                        </a>
                    </Navbar.Brand>
                    <Navbar.Brand>
                        <Link to='/registration'>
                            Registration
                        </Link>
                    </Navbar.Brand>
                </Navbar.Header>
            </Navbar>
        );
    }
}

export default MainHeader;

{/*<div>*/
}
{/*<Navbar>*/
}
{/*<Navbar.Header>*/
}
{/*<Navbar.Brand>*/
}
{/*<Link to='/'>Home</Link>*/
}
{/*</Navbar.Brand>*/
}
{/*<Navbar.Brand>*/
}
{/*<Link to='/admin'>Admin</Link>*/
}
{/*</Navbar.Brand>*/
}
{/*<Navbar.Collapse>*/
}
{/*<Nav navbar>*/
}
{/*<Link to='/login'>*/
}
{/*<NavItem>Login</NavItem>>*/
}
{/*</Link>*/
}
{/*<Link to='/registration'>*/
}
{/*<NavItem>Registration</NavItem>>*/
}
{/*</Link>*/
}
{/*</Nav>*/
}
{/*</Navbar.Collapse>*/
}
{/*</Navbar.Header>*/
}
{/*</Navbar>*/
}
{/*</div>*/
}
