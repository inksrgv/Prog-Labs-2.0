package commands;
public class CommandsCover {
        /**
         * command cover class for command parsing
         */
        private final String argument;
        private final String command;
        public CommandsCover(String cmd, String arg){
            argument = arg;
            command = cmd;
        }
        public CommandsCover(String cmd){
            argument = null;
            command = cmd;
        }

        public String getCommand(){
            return command;
        }

        public String getArg(){
            return argument;
        }
    }

