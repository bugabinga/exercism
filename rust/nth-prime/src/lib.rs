pub fn nth(n: u32) -> Option<u32> {
  if n == 0 {
    return Option::None;
  }

  let mut prime_candidate = 1;
  let mut counter = 0;

  while counter != n {
    prime_candidate = prime_candidate + 1;
    if is_prime(prime_candidate) {
      counter = counter + 1;
    }
  }

  Option::from(prime_candidate)
}

fn is_prime(n: u32) -> bool {
  if n < 2 {
    return false;
  }

  //this effectively filters out the second factor of the products we test
  let search_space = square_root(n) + 1;
  for factor in 2..search_space {
    if n % factor == 0 {
      return false;
    }
  }

  return true;
}

fn square_root(n: u32) -> u32 {
  ((n as f64).sqrt()) as u32
}
