pub fn reply(message: &str) -> &str {
  let trimmed_message = message.trim();

  if is_silence(trimmed_message) {
    return "Fine. Be that way!";
  }

  if is_question(trimmed_message) && is_shouting(trimmed_message) {
    return "Calm down, I know what I'm doing!";
  }

  if is_shouting(trimmed_message) {
    return "Whoa, chill out!";
  }

  if is_question(trimmed_message) {
    return "Sure.";
  }

  "Whatever."
}

fn is_shouting(text: &str) -> bool {
  let alphas: Vec<_> = text
    .chars()
    .filter(|c| c.is_alphabetic())
    .filter(|c| !c.is_whitespace())
    .collect();

  //all() on empty sets always returns true. in this case, this is
  //not what we want
  alphas.iter().all(|c| c.is_uppercase()) && !alphas.is_empty()
}

fn is_question(text: &str) -> bool {
  text.ends_with('?')
}

fn is_silence(text: &str) -> bool {
  text.is_empty()
}
