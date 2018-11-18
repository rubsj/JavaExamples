### Union Find Algorithms
#### Concepts
 - union–find data type is also known as the disjoint-sets data type
 - The union–find data type models connectivity among a set of n sites, named 0 through n–1
 - The is-connected-to relation must be an equivalence relation:
   * Reflexive : p is connected to  p
   * Symmetric : if p is connected to q then q is connected to p
   * transitive : if p is connected to q and q is connected to r then p is connected to r
 - An equivalence relation partitions the sites into equivalence classes or components
 - two sites are in the same component if and only if they are connected.
 - Both sites and components are identified with integers between 0 and n-1
 - Initially, there are n components, with each site in its own component.
 - The component identifier of a component (also known as the root, canonical element, leader, or set representative) is one of the sites in the component
 - two sites have the same component identifier if and only if they are in the same component.
 - union p, q adds  connection between the two sites p ,q if p and q are in different components,then it replaces
 the two component with a new component that is the union of the two
 - find returns the component identifier of the component containing p 
 - connected returns true if p and q both are in the same component false otherwise
 - count returns the number of component
 - The component identifier of a component can change only when the component itself changes during a call to union. it can not change otherwise
 
 | Algorithm | WorstCase time |
 | --- | --- | 
 |Quick Find | MN |
 |Quick Union| MN | 
 |weighted quick union| n + MlogN|
 |QU + path compression | N  + MLogN|
 |Weighted QU + path compression| N+M Lg* N|
 
- m union-find operation on a set of N objects
- lg* mean log to the base 2

### Stacks and Queues
#### Concepts
 - Java generics. Explain why Java prohibits generic array creation.
    * sefew


