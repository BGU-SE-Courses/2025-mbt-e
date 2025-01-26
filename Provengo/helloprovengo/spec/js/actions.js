function navigateToProductPage(session) {
  session.waitForVisibility(xpaths.productPage.product, 10000);
  session.click(xpaths.productPage.product);
}

function addToCart(session) {
  session.waitForVisibility(xpaths.productPage.addToCartButton, 10000);
  session.click(xpaths.productPage.addQuantityButton);
  session.waitForVisibility(xpaths.productPage.addToCartButton, 10000);
  session.click(xpaths.productPage.addToCartButton);
}

function navigateToCart(session) {
  session.waitForVisibility(xpaths.cart.proceedToCheckoutButton, 10000);
  session.click(xpaths.cart.proceedToCheckoutButton);
}

function proceedToCheckout(session) {
  session.waitForVisibility(xpaths.cart.proceedToCheckoutButton2, 10000);
  session.click(xpaths.cart.proceedToCheckoutButton2);
}

function fillCheckoutDetails(session) {
  session.waitForVisibility(xpaths.checkout.mrs, 10000);
  session.click(xpaths.checkout.mrs);
  session.waitForVisibility(xpaths.checkout.firstName, 10000);
  session.writeText(xpaths.checkout.firstName, testUser.firstName);
  session.waitForVisibility(xpaths.checkout.lastName, 10000);
  session.writeText(xpaths.checkout.lastName, testUser.lastName);

  //session.runCode(scrolling.down);
  session.waitForVisibility(xpaths.checkout.email, 10000);
  session.writeText(xpaths.checkout.email, testUser.email);

  //session.scrollToElement(xpaths.checkout.agreeBox);
  session.waitForVisibility(xpaths.checkout.agreeBox, 10000);
  session.click(xpaths.checkout.agreeBox);
  session.waitForVisibility(xpaths.checkout.dataPrivacyBox, 10000);
  session.click(xpaths.checkout.dataPrivacyBox);
  session.waitForVisibility(xpaths.checkout.continueButton, 10000);
  session.click(xpaths.checkout.continueButton);

  session.waitForVisibility(xpaths.checkout.address, 100000);
  session.writeText(xpaths.checkout.address, testUser.address);
  session.waitForVisibility(xpaths.checkout.city, 100000);
  session.writeText(xpaths.checkout.city, testUser.city);
  session.waitForVisibility(xpaths.checkout.postcode, 100000);
  session.writeText(xpaths.checkout.postcode, "12345");
  session.waitForVisibility(xpaths.checkout.countryDropdown, 100000);
  session.click(`//option[text()='France']`);
  session.waitForVisibility(xpaths.checkout.continueButton1, 100000);
  session.click(xpaths.checkout.continueButton1);
}

function confirmOrder(session) {
  session.waitForVisibility(xpaths.checkout.confirmOrderButton, 20000);
  session.click(xpaths.checkout.confirmOrderButton);
}

function payment(session) {
    session.waitForVisibility(xpaths.payment.paymentMethod, 20000);
    session.click(xpaths.payment.paymentMethod);
    session.waitForVisibility(xpaths.payment.paymentConfirmation, 20000);
    session.click(xpaths.payment.paymentConfirmation);
    session.waitForVisibility(xpaths.payment.orderConfirmation, 20000);
    session.click(xpaths.payment.orderConfirmation);
}

function verifyConfirmationMessage(session) {
  session.waitForVisibility(xpaths.orderConfirmation.confirmationMessage, 500000);
}

/* Admin Actions */
function open_prestashop_admin(session){
  session.start(ADMIN_URL);
}
function loginAsAdmin(session) {
  session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.email, 10000);
  session.writeText(xpaths_ADMIN.Admin_loginForm.email, Admin_email);
  session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.password, 10000);
  session.writeText(xpaths_ADMIN.Admin_loginForm.password, Admin_password);
  session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.submitButton, 10000);
  session.click(xpaths_ADMIN.Admin_loginForm.submitButton);
  session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.dashboard, 10000);
}

function navigateToCatalog(session) {
  session.waitForVisibility(xpaths_ADMIN.catalog.catalogMenu, 10000);
  session.click(xpaths_ADMIN.catalog.catalogMenu);
}

function selectProduct(session) {
  session.waitForVisibility(xpaths_ADMIN.catalog.productsMenu, 10000);
  session.click(xpaths_ADMIN.catalog.productsMenu);
  session.waitForVisibility(xpaths_ADMIN.catalog.firstProductEdit, 10000);
  session.click(xpaths_ADMIN.catalog.firstProductEdit)
  session.waitForVisibility(xpaths_ADMIN.catalog.productEditLabel, 10000);
}

function updateMaxQuantity(session) {
  session.writeText(xpaths_ADMIN.stock.deltaQuantity, Quantity_To_Delete, true);
  session.click(xpaths_ADMIN.stock.saveButton);
  session.waitForVisibility(xpaths_ADMIN.stock.successMessage,10000);
}
