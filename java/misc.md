|-----------------------------------|
|          GenericStack<E>          |
|-----------------------------------|
| - elements: E[]                   |
| - size: int                       |
| - DEFAULT_CAPACITY: int = 10      |
|-----------------------------------|
| + GenericStack()                  |
| + push(value: E): void            |
| + pop(): E                        |
| + peek(): E                       |
| + isEmpty(): boolean              |
| - expandCapacity(): void          |
| + toString(): String              |
|-----------------------------------|

|-----------------------------------|
|         GenericStack1<E>          |
|       extends ArrayList<E>        |
|-----------------------------------|
| + GenericStack1()                 |
| + push(value: E): void            |
| + pop(): E                        |
| + peek(): E                       |
|-----------------------------------|
