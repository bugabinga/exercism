// Find the product of a Pythagorean triplet for which a+b+c = 1000.
// The exercise is a little ambigous about the exact set of natural numbers.
// Is zero included?
// Here a set of N = {1,2,3,...} is assumed, because the exercise states,
// "there exists exactly one Pythagorean triplet", which is obviously untrue,
// when zero is allowed.
pub fn find() -> Option<u32> {
    /*
a + b + c = 1000

Triplet: d(m² - n²), d2mn, d(m² + n²) for some integers d,m,n

a = (m² - n²)
b = 2mn
c = (m² + n²)

m < n

*/
  
    let mut m = 1;
    let mut n = 2;
  
    loop {
      let a = m*m - n*n;
      let b = 2*m*n;
      let c = m*m + n*n;
    
      let sum = a + b + c;
      if sum == 1000 {
        return Some(a*b*c);
    }
    else if sum > 1000 {
        return None;
    }
  }
  