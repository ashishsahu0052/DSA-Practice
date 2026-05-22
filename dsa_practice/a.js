// let obj = {
//   a: {
//     b: undefined,
//   },
// };

// console.log(obj.a?.b?.c?.d ?? "jatin");

var abc = 2;
function f() {}
if (f()) {
  abc = abc + typeof f;
}
console.log(abc);
