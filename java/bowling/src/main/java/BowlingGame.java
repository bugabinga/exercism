import java.util.ArrayList;
import java.util.List;

class BowlingGame
{
  private static final int STRIKE = 10;

  private final List<Integer> rolls = new ArrayList<>( 10 );

  void roll( final int pins )
  {
    rolls.add( pins );
  }

  int score()
  {
    final var frames = calculateFrames(rolls);
    for ( int index = 0; index < frames.size(); index++ )
    {

    }
    return 0;
  }
}
