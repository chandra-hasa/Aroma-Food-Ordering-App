import React from 'react';
import {Link} from 'react-router-dom';

function OrderConfirm() {
    return (
        <div>
            <div class="card">
                
                <div class="card-body">
                    <h5 class="card-title">Order Placed</h5>
                    <p class="card-text"></p>
                    <Link to={'/menu'} class="btn btn-warning">Go to Menu</Link>
                </div>
</div>
        </div>
    )
}

export default OrderConfirm
