/* @provengo summon selenium */

/**
 * Admin path: Update product quantity
 */

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