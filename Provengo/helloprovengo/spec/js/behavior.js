/* @provengo summon selenium */

const session = new SeleniumSession("UserSession");

// Setup thread
bthread('Setup Session', function () {
    session.start(URL); // Start the session once
    sync({ request: Event('Session Started') }); // Signal that the session is ready
});

// Behavior: Add Product to Cart
bthread('Add Product to Cart', function () {
    sync({ waitFor: Event('Session Started') }); // Wait for the session to be ready
    navigateToProductPage(session);
    addToCart(session);
    sync({ request: Event('Added to Cart') }); // Signal that product was added

});

// Behavior: Checkout Process
bthread('Checkout Process', function () {
    sync({ waitFor: Event('Added to Cart') }); // Wait for the product to be added
    navigateToCart(session);
    proceedToCheckout(session);
    fillCheckoutDetails(session);
    confirmOrder(session);
    payment(session);
    verifyConfirmationMessage(session);
});


const Admin_selemiumsessiom = new SeleniumSession("AdminSession")
bthread('Admin change product quantity', function() {
    with (Admin_selemiumsessiom) {
        open_prestashop_admin(Admin_selemiumsessiom);
        loginAsAdmin(Admin_selemiumsessiom);
        navigateToCatalog(Admin_selemiumsessiom);
        selectProduct(Admin_selemiumsessiom);
        updateMaxQuantity(Admin_selemiumsessiom);
    }
});