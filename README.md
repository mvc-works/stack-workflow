
Stack Workflow
----

Personal project template based on Respo, Boot, ClojureScript, Cirru Sepal...

### Develop

Genetate HTML(`target/index.html`), watch and build ClojureScript:

```bash
boot dev!
```

Compile and optimize ClojureScript, generate HTML with revision:

```bash
boot build-advanced
export boot_deps=`boot show -c`
planck -c $boot_deps:src/ -i render.cljs
```

Package jar file and install locally:

```bash
boot build
```

Package jar file and send to Clojars:

```bash
boot deploy
```

Get ClojureScript code:

```bash
boot generate-code
```

### Develop

Workflow https://github.com/mvc-works/stack-workflow

### License

MIT
