pub fn verse(n: u32) -> String {
    let verse;

    if n == 0 {
        verse = String::from("No more bottles of beer on the wall, no more bottles of beer.\nGo to the store and buy some more, 99 bottles of beer on the wall.\n");
    } else if n == 1 {
        verse = String::from("1 bottle of beer on the wall, 1 bottle of beer.\nTake it down and pass it around, no more bottles of beer on the wall.\n");
    } else if n == 2 {
        verse = String::from("2 bottles of beer on the wall, 2 bottles of beer.\nTake one down and pass it around, 1 bottle of beer on the wall.\n");
    } else {
        verse = format!("{} bottles of beer on the wall, {} bottles of beer.\nTake one down and pass it around, {} bottles of beer on the wall.\n",n,n,n-1);
    }

    verse
}

pub fn sing(start: u32, end: u32) -> String {
    (end..start + 1).rev().map(|n| verse(n)).collect()
}
