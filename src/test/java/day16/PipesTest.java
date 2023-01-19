package day16;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PipesTest {
    @Test
    void sampeInput_solve_result() {
        String input = """
                Valve AA has flow rate=0; tunnels lead to valves DD, II, BB
                Valve BB has flow rate=13; tunnels lead to valves CC, AA
                Valve CC has flow rate=2; tunnels lead to valves DD, BB
                Valve DD has flow rate=20; tunnels lead to valves CC, AA, EE
                Valve EE has flow rate=3; tunnels lead to valves FF, DD
                Valve FF has flow rate=0; tunnels lead to valves EE, GG
                Valve GG has flow rate=0; tunnels lead to valves FF, HH
                Valve HH has flow rate=22; tunnel leads to valve GG
                Valve II has flow rate=0; tunnels lead to valves AA, JJ
                Valve JJ has flow rate=21; tunnel leads to valve II""";
        Pipes cut = new Pipes();
        int result = cut.solve(input);
        assertThat(result).isEqualTo(1651);
    }

    @Test
    void puzzleInput_solve_result() {
        String input = """
                Valve RT has flow rate=0; tunnels lead to valves EN, LZ
                Valve VB has flow rate=0; tunnels lead to valves SZ, BF
                Valve AD has flow rate=0; tunnels lead to valves EB, JF
                Valve RE has flow rate=4; tunnels lead to valves QB, IF, XT, WF, KW
                Valve RL has flow rate=0; tunnels lead to valves DQ, LZ
                Valve OK has flow rate=0; tunnels lead to valves QH, BF
                Valve RV has flow rate=0; tunnels lead to valves IU, JF
                Valve TE has flow rate=0; tunnels lead to valves HE, XF
                Valve WW has flow rate=0; tunnels lead to valves QH, YZ
                Valve HB has flow rate=15; tunnel leads to valve OM
                Valve IY has flow rate=14; tunnels lead to valves UH, KW, BN, LW, UY
                Valve QF has flow rate=0; tunnels lead to valves JF, PL
                Valve YZ has flow rate=0; tunnels lead to valves JG, WW
                Valve QB has flow rate=0; tunnels lead to valves SP, RE
                Valve SO has flow rate=0; tunnels lead to valves QH, SZ
                Valve EB has flow rate=7; tunnels lead to valves IF, NH, AD, VI, DQ
                Valve VL has flow rate=0; tunnels lead to valves JF, YV
                Valve BF has flow rate=18; tunnels lead to valves OK, VB, OH, SX
                Valve UC has flow rate=0; tunnels lead to valves SC, YV
                Valve OQ has flow rate=0; tunnels lead to valves XT, AA
                Valve YV has flow rate=6; tunnels lead to valves YX, TT, VL, UC, NH
                Valve KJ has flow rate=0; tunnels lead to valves OH, JG
                Valve QH has flow rate=20; tunnels lead to valves SO, OK, WW
                Valve KW has flow rate=0; tunnels lead to valves RE, IY
                Valve PL has flow rate=0; tunnels lead to valves JG, QF
                Valve DQ has flow rate=0; tunnels lead to valves EB, RL
                Valve AA has flow rate=0; tunnels lead to valves YI, EN, UK, OQ, VI
                Valve XT has flow rate=0; tunnels lead to valves OQ, RE
                Valve SZ has flow rate=24; tunnels lead to valves VB, SO
                Valve IU has flow rate=25; tunnels lead to valves RV, HE, HQ
                Valve OM has flow rate=0; tunnels lead to valves NY, HB
                Valve YX has flow rate=0; tunnels lead to valves YV, SI
                Valve SX has flow rate=0; tunnels lead to valves ZB, BF
                Valve KD has flow rate=0; tunnels lead to valves XF, LW
                Valve SP has flow rate=0; tunnels lead to valves XF, QB
                Valve UY has flow rate=0; tunnels lead to valves UK, IY
                Valve XF has flow rate=22; tunnels lead to valves SP, TE, KD, NY
                Valve SC has flow rate=0; tunnels lead to valves LZ, UC
                Valve UK has flow rate=0; tunnels lead to valves UY, AA
                Valve LW has flow rate=0; tunnels lead to valves KD, IY
                Valve FL has flow rate=0; tunnels lead to valves BN, LZ
                Valve VI has flow rate=0; tunnels lead to valves AA, EB
                Valve HW has flow rate=0; tunnels lead to valves JF, CY
                Valve YI has flow rate=0; tunnels lead to valves AA, TT
                Valve HE has flow rate=0; tunnels lead to valves IU, TE
                Valve JG has flow rate=10; tunnels lead to valves PL, YZ, SI, KJ
                Valve BN has flow rate=0; tunnels lead to valves IY, FL
                Valve IF has flow rate=0; tunnels lead to valves EB, RE
                Valve JF has flow rate=19; tunnels lead to valves HW, QF, VL, RV, AD
                Valve SI has flow rate=0; tunnels lead to valves JG, YX
                Valve WF has flow rate=0; tunnels lead to valves LZ, RE
                Valve HQ has flow rate=0; tunnels lead to valves IU, UH
                Valve LZ has flow rate=5; tunnels lead to valves SC, FL, WF, RL, RT
                Valve UH has flow rate=0; tunnels lead to valves IY, HQ
                Valve CY has flow rate=21; tunnel leads to valve HW
                Valve NH has flow rate=0; tunnels lead to valves EB, YV
                Valve TT has flow rate=0; tunnels lead to valves YV, YI
                Valve OH has flow rate=0; tunnels lead to valves KJ, BF
                Valve EN has flow rate=0; tunnels lead to valves RT, AA
                Valve NY has flow rate=0; tunnels lead to valves OM, XF
                Valve ZB has flow rate=8; tunnel leads to valve SX""";
        Pipes cut = new Pipes();
        int result = cut.solve(input);
        assertThat(result).isEqualTo(1651);
    }
}