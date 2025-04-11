# Mariyoko

Mariyoko is a *really tiny* programming language that checks whether 
your logic is sound.  It is intended to merge with the Neve compiler 
once proven to work.

## Grammar

Mariyoko is really simple, so simple that its grammar can fit into a
`README` file.  And that’s why we’re going to put it here.

### Expressions

Mariyoko supports a select few *arithmetic* expressions:

* Addition: `a + b`
* Subtraction: `a - b`
* Multiplication: `a * b`
* Division: `a / b`

The language also support logical expressions:

* Equality: `a == b`
* Inequality: `a != b`
* Greater than: `a > b`
* Greater than or equal: `a >= b`
* Less than: `a < b`
* Less than or equal: `a <= b`
* Inclusion: `a in ]x, y[`

### Statements

Mariyoko supports 3 statements in total:

* `let` statements
* `assume` statements
* `prove` statements

Let’s work through each one of them in detail.

#### Let Statements

`let` statements let Mariyoko know that we are 
declaring a symbol to be used later.  If you 
write:

```ruby
assume a < b
assume c > b
prove c > a
```

Mariyoko will complain; you need to *first 
declare* your symbols like so:

```ruby
let a, b, c
```

You can also impose further constraints on 
a symbol, such as:

```ruby
let a in ]-inf, 5[ union ]10, +inf[, 
    b in [10, 20],
    c
```

#### Assume statements

`assume` statements tell Mariyoko to check 
whether the given expression is possible, and
if it is, assume it is true for `prove` statements.

For example, without `assume` statements, this `prove`
statement fails:

```ruby
let a, b, c
prove a < c
```

However, if we add `assume` statements:

```ruby
let a, b, c
assume a < b
assume b < c

prove a < c
```

Here is another example where the assume 
statement fails:

```ruby
let a in ]-inf, 10[,
    b in ]-inf, 9[
    
assume a == b
```

#### Prove statements

`prove` statements check whether a condition 
is true and output it to `stdout`.  The steps 
taken will be shown too.