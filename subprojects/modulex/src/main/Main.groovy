

import acme.TaskConfig

class Main {

    TaskConfig taskConfig = new TaskConfig([shell:'hello'])

    def Main() {
        println taskConfig.shell
    }

    static void main(String[] args) {
        new Main()
    }

}
