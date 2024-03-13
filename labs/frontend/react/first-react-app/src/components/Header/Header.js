// import
import MenuList from '../MenuList/MenuList';
import './Header.css';

// Component Definition
const Header = () => {
  // return JSX
  return (
    // <header className="text-center">
    //   <h3>React Demo App</h3>
    //   <hr/>
    // </header>

    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark ">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">React Demo App</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarCollapse">
          <ul class="navbar-nav me-auto mb-2 mb-md-0 text-center">
            {/* <li class="nav-item">
              <a class="nav-link active" aria-current="page" href=" #">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Features</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="#">Pricing</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" aria-current="page" href="#">FAQs</a>
            </li>
            <li class="nav-item">
              <a class="nav-link  " aria-disabled="true">About</a>
            </li> */}
          <MenuList menuItem1="Home" menuItem2="Products" menuItem3="Categories" menuItem4="About Us"/>
          </ul>
          <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
              <button class="btn btn-outline-success" type="submit">Search</button>
          </form>
        </div>
      </div>
    </nav>
  )
}

// export
export default Header