use std::str;
use std::string::String;

pub fn reverse(something: &str) -> String {
    something.chars().rev().collect()
}
