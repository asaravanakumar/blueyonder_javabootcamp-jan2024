import React from 'react'

const MenuList = (props) => {

  const products = "Items";
  return (
    <>
      {/* <ul class="nav justify-content-center border-bottom pb-1 mb-1"> */}
        <li class="nav-item"><a href="#" class="nav-link px-2 text-secondary">{props.menuItem1}</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-secondary">{props.menuItem2}</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-secondary">{props.menuItem3}</a></li>
        <li class="nav-item"><a href="#" class="nav-link px-2 text-secondary">{props.menuItem4}</a></li>
      {/* </ul> */}
    </>
  )
}

export default MenuList
