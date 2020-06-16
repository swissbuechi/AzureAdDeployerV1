package ch.netider.AzureAdDeployer.service.exo;

import ch.netider.AzureAdDeployer.session.PsSession;

public class ExoService {

    private final PsSession session = new PsSession("ExoSession") {
        @Override
        public String run(String... input) {

            return null;
        }
    };


}
