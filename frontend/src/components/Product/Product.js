import React, {Component} from 'react';
import {connect} from "react-redux";

class Product extends Component {

  render() {
    const productsList = this.props.products;
    console.log(this.props);
    const products = productsList.map((product) => {

      return (
          <div>
            {product.name}
          </div>
      )
    });

    return (
        <div className="container">
          <h1>Products list</h1>
          {products}
        </div>
    )
  }
}

function mapStateToProps(state) {
  return {
    products: state.products
  }
}

export default connect(mapStateToProps)(Product);
