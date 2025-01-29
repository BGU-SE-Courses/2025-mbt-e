// // @provengo summon ctrl
//
// /**
//  * List of events "of interest" that we want test suites to cover.
//  */
// const GOALS = [
//     any(/Howdy/),
//     any(/Mars/),
//     Ctrl.markEvent("Classic!")
// ];
//
// const makeGoals = function(){
//     return [ [ any(/Howdy/), any(/Venus/) ],
//              [ any(/Mars/) ],
//              [ Ctrl.markEvent("Classic!") ] ];
// }
//
// /**
//  * Ranks test suites by how many events from the GOALS array were met.
//  * The more goals are met, the higher the score.
//  *
//  * It make no difference if a goal was met more then once.
//  *
//  * @param {Event[][]} ensemble The test suite to be ranked.
//  * @returns Number of events from GOALS that have been met.
//  */
// function rankByMetGoals( ensemble ) {
//     const unreachedGoals = [];
//     for ( let idx=0; idx<GOALS.length; idx++ ) {
//         unreachedGoals.push(GOALS[idx]);
//     }
//
//     for (let testIdx = 0; testIdx < ensemble.length; testIdx++) {
//         let test = ensemble[testIdx];
//         for (let eventIdx = 0; eventIdx < test.length; eventIdx++) {
//             let event = test[eventIdx];
//             for (let ugIdx=unreachedGoals.length-1; ugIdx >=0; ugIdx--) {
//                 let unreachedGoal = unreachedGoals[ugIdx];
//                 if ( unreachedGoal.contains(event) ) {
//                     unreachedGoals.splice(ugIdx,1);
//                 }
//             }
//         }
//     }
//
//     return GOALS.length-unreachedGoals.length;
// }
//
// /**
//  * Ranks potential test suites based on the percentage of goals they cover.
//  * Goal events are defined in the GOALS array above. An ensemble with rank
//  * 100 covers all the goal events.
//  *
//  * Multiple ranking functions are supported - to change ranking function,
//  * use the `ensemble.ranking-function` configuration key, or the
//  * --ranking-function <functionName> command-line parameter.
//  *
//  * @param {Event[][]} ensemble the test suite/ensemble to be ranked
//  * @returns the percentage of goals covered by `ensemble`.
//  */
//  function rankingFunction(ensemble) {
//
//     // How many goals did `ensemble` hit?
//     const metGoalsCount = rankByMetGoals(ensemble);
//     // What percentage of the goals did `ensemble` cover?
//     const metGoalsPercent = metGoalsCount/GOALS.length;
//
//     return metGoalsPercent * 100; // convert to human-readable percentage
// }

// @provengo summon ctrl

/**
 * List of events "of interest" that we want test suites to cover.
 * These represent key actions that must be included in test scenarios.
 */
const GOALS = [
    any(/Start\(UserSession\)/),
    any(/End\(UserSession\)/),
    any(/Start\(AdminSession\)/),
    any(/End\(AdminSession\)/),

    any(/Start\(navigateToProductPage\)/),
    any(/End\(navigateToProductPage\)/),
    any(/Start\(addToCart\)/),
    any(/End\(addToCart\)/),
    any(/Start\(navigateToCart\)/),
    any(/End\(navigateToCart\)/),
    any(/Start\(proceedToCheckout\)/),
    any(/End\(proceedToCheckout\)/),
    any(/Start\(fillCheckoutDetails\)/),
    any(/End\(fillCheckoutDetails\)/),
    any(/Start\(confirmOrder\)/),
    any(/End\(confirmOrder\)/),
    any(/Start\(payment\)/),
    any(/End\(payment\)/),

    any(/Start\(AdminLogin\)/),
    any(/End\(AdminLogin\)/),
    any(/Start\(updateMaxQuantity\)/),
    any(/End\(updateMaxQuantity\)/),
];

/**
 * Defines critical sequences that must occur in order.
 * These sequences ensure valid workflows in testing.
 */
const makeGoals = function() {
    return [
        // User Flow
        [any(/Start\(UserSession\)/), any(/End\(UserSession\)/)],
        [any(/Start\(navigateToProductPage\)/), any(/End\(navigateToProductPage\)/)],
        [any(/End\(navigateToProductPage\)/), any(/Start\(addToCart\)/)],
        [any(/End\(addToCart\)/), any(/Start\(navigateToCart\)/)],
        [any(/End\(navigateToCart\)/), any(/Start\(proceedToCheckout\)/)],
        [any(/End\(proceedToCheckout\)/), any(/Start\(fillCheckoutDetails\)/)],
        [any(/End\(fillCheckoutDetails\)/), any(/Start\(confirmOrder\)/)],
        [any(/End\(confirmOrder\)/), any(/Start\(payment\)/)],
        [any(/End\(payment\)/), any(/End\(UserSession\)/)],

        // Admin Flow
        [any(/Start\(AdminSession\)/), any(/End\(AdminSession\)/)],
        [any(/Start\(AdminLogin\)/), any(/End\(AdminLogin\)/)],
        [any(/Start\(updateMaxQuantity\)/), any(/End\(updateMaxQuantity\)/)],

        // Admin modifies stock AFTER checkout
        [any(/End\(payment\)/), any(/Start\(updateMaxQuantity\)/)]
    ];
};

/**
 * Ranks test suites based on how many `GOALS` events were met.
 * Higher scores mean more comprehensive test coverage.
 */
function rankByMetGoals(ensemble) {
    const unreachedGoals = GOALS.slice();

    for (let test of ensemble) {
        for (let event of test) {
            for (let ugIdx = unreachedGoals.length - 1; ugIdx >= 0; ugIdx--) {
                let unreachedGoal = unreachedGoals[ugIdx];
                if (unreachedGoal.contains(event)) {
                    unreachedGoals.splice(ugIdx, 1);
                }
            }
        }
    }

    return GOALS.length - unreachedGoals.length;
}

/**
 * Computes ranking based on the percentage of goals met.
 */
function rankingFunction(ensemble) {
    //const metGoalsCount = rankByMetGoals(ensemble);
    //return (metGoalsCount / GOALS.length) * 100;
    return two_ways_ranking_function(ensemble);
}

/**
 * Alternative ranking method to count unique event pairs.
 * Helps measure transition coverage in tests.
 */
function two_ways_ranking_function(ensemble) {
    let set = new Set();
    for (let test of ensemble) {
        for (let i = 0; i < test.length - 1; i++) {
            set.add(`${test[i]},${test[i+1]}`);
        }
    }
    return set.size;
}


