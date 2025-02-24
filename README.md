# TCG Pokemon

This project was built with a MVVM architecture using Hilt to simplify dependency injection and reduce boilerplate code.

As you can see, for networking i've used retrofit with Hilt.

At the start of the application is initiated the Navigation Component and it starts the CardList screen.

I've tried to create some reusable components to reduce code duplication.

# Unit Test

Run all tests from Run Configurations:

- Click on the Run/Debug Configurations dropdown (at the top).
- Select Edit Configurations.
- Under Android JUnit, create a new configuration if needed.
- Select All in Package and set it to com.arc.tcg (or your package name).
- Click Apply and OK.
- Click Run ▶️.