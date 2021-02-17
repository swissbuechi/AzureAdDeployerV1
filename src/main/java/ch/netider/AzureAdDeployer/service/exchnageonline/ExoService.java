package ch.netider.AzureAdDeployer.service.exchnageonline;

import ch.netider.AzureAdDeployer.session.PoweShellSession;

public class ExoService {

    private final PoweShellSession session = new PoweShellSession("ExoSession") {
        @Override
        public String execute(String... input) {

            return null;
        }
    };
}
