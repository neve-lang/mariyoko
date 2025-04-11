import cli.Args
import cli.mode.Mode
import cli.repl.Repl
import mariyoko.Mariyoko

fun main(args: Array<String>) = when (val mode = Args.from(args).mode()) {
    is Mode.Normal -> Mariyoko().run(mode.filename)
    is Mode.Repl -> Repl().run()
}