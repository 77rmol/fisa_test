Feature: Happiness Song

  @test
  Scenario Outline: Virtual Piano
    Given i want to play a song
    When i send the "<melodie>"
    Then i can ear the melodie
    Examples:
      | melodie                                                                                                                                                                                          |
      | si, si, do, re, re, do, si, la, sol, sol, la, si, si, la, la                                                                                                                                     |
      | si, si, do, re, re, do, si, la, sol, sol, la, si, si, la, la,si, si, do, re, re, do, si, la, sol, sol, la, si, si, la, la                                                                        |
      | si, si, do, re, re, do, si, la, sol, sol, la, si, la, sol, sol, la, si, sol, la, si, do, si, sol, la, si, do, si, sol, sol, fa, re, si, si, do, re, re, do, si, la, sol, sol, la, si, si, la, la |