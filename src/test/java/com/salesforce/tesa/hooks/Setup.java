    package com.salesforce.tesa.hooks;

    import com.salesforce.tesa.utils.Context;
    import io.cucumber.java.Before;
    import net.serenitybdd.screenplay.actors.OnStage;
    import net.serenitybdd.screenplay.actors.OnlineCast;

    public class Setup {
        private Context context;

        @Before
        public void setUp() {
            OnStage.setTheStage(new OnlineCast());
            OnStage.theActorCalled("user");
            context = new Context();
        }

        public Context getContext() {
            return context;
        }
    }
