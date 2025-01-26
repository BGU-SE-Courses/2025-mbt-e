/* Admin Actions */

function open_prestashop_admin(session){
    session.start(ADMIN_URL);
    }
function loginAsAdmin(session) {
    session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.email, 5000);
    session.writeText(xpaths_ADMIN.Admin_loginForm.email, Admin_email);
    session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.password, 5000);
    session.writeText(xpaths_ADMIN.Admin_loginForm.password, Admin_password);
    session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.submitButton, 5000);
    session.click(xpaths_ADMIN.Admin_loginForm.submitButton);
    session.waitForVisibility(xpaths_ADMIN.Admin_loginForm.dashboard, 5000);
    }

function navigateToCatalog(session) {
    session.waitForVisibility(xpaths_ADMIN.catalog.catalogMenu, 5000);
    session.click(xpaths_ADMIN.catalog.catalogMenu);
}

function selectProduct(session) {
    session.waitForVisibility(xpaths_ADMIN.catalog.productsMenu, 5000);
    session.click(xpaths_ADMIN.catalog.productsMenu);
    session.waitForVisibility(xpaths_ADMIN.catalog.firstProductEdit, 5000);
    session.click(xpaths_ADMIN.catalog.firstProductEdit)
    session.waitForVisibility(xpaths_ADMIN.catalog.productEditLabel, 5000);
}

function updateMaxQuantity(session) {
    session.writeText(xpaths_ADMIN.stock.deltaQuantity, Quantity_To_Delete, true);
    session.click(xpaths_ADMIN.stock.saveButton);
    session.waitForVisibility(xpaths_ADMIN.stock.successMessage, 5000);
    }