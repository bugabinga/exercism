import java.util.List;

class Knapsack
{
  static int maximumValue( final int maxWeight, final List<Item> items )
  {
    return knapsackRecursive( items, items.size(), maxWeight );
  }

  private static int knapsackRecursive( final List<Item> items, final int size, final int maxWeight )
  {
    if ( size <= 0 )
    {
      return 0;
    }
    else
    {
      final var lastItem = size - 1;
      if ( items.get( lastItem ).weigth() > maxWeight )
      {
        return knapsackRecursive( items, lastItem, maxWeight );
      }
      else
      {
        return Math.max(
            knapsackRecursive( items, size - 1, maxWeight ),
            items.get( lastItem ).value() + knapsackRecursive( items, size - 1,
                maxWeight - items.get( lastItem ).weigth() ) );
      }
    }
  }
}

