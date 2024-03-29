package day21;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MonkeyRiddleGameTest {
    private static final String INPUT = """
            root: pppw + sjmn
            dbpl: 5
            cczh: sllz + lgvd
            zczc: 2
            ptdq: humn - dvpt
            dvpt: 3
            lfqf: 4
            humn: 5
            ljgn: 2
            sjmn: drzm * dbpl
            sllz: 4
            pppw: cczh / lfqf
            lgvd: ljgn * ptdq
            drzm: hmdt - zczc
            hmdt: 32""";

    @Test
    void simpleInput_getNumberOfMonkeyShoutingOnlyNumber_number() {
        MonkeyRiddleGame cut = new MonkeyRiddleGame(INPUT);
        assertThat(cut.getShoutingNumberOf("hmdt")).isEqualTo(32);
    }

    @Test
    void simpleInput_getNumberOfRoot_number() {
        MonkeyRiddleGame cut = new MonkeyRiddleGame(INPUT);
        assertThat(cut.getShoutingNumberOf("root")).isEqualTo(152);
    }

    @Test
    void monkeyIsPartOfPlusOperation_getNumberOfMonkeyShoutingOnlyNumber_number() {
        MonkeyRiddleGame cut = new MonkeyRiddleGame("""
                cczh: sllz + lgvd
                sllz: 2
                lgvd: 3""");
        assertThat(cut.getShoutingNumberOf("cczh")).isEqualTo(5);
    }

    @Test
    void monkeyIsPartOfRecursivePlusOperation_getNumberOfMonkeyShoutingOnlyNumber_number() {
        MonkeyRiddleGame cut = new MonkeyRiddleGame("""
                cczh: sllz + lgvd
                sllz: lgvd + aaab
                lgvd: 3
                aaab: 4""");
        assertThat(cut.getShoutingNumberOf("cczh")).isEqualTo(10);
    }

    @Test
    void monkeyIsPartOfMinusOperation_getNumberOfMonkeyShoutingOnlyNumber_number() {
        MonkeyRiddleGame cut = new MonkeyRiddleGame("""
                cczh: sllz - lgvd
                sllz: 2
                lgvd: 3""");
        assertThat(cut.getShoutingNumberOf("cczh")).isEqualTo(-1);
    }

    @Test
    void monkeyIsPartOfMultiplyOperation_getNumberOfMonkeyShoutingOnlyNumber_number() {
        MonkeyRiddleGame cut = new MonkeyRiddleGame("""
                cczh: sllz * lgvd
                sllz: 2
                lgvd: 3""");
        assertThat(cut.getShoutingNumberOf("cczh")).isEqualTo(6);
    }

    @Test
    void monkeyIsPartOfDivisionOperation_getNumberOfMonkeyShoutingOnlyNumber_number() {
        MonkeyRiddleGame cut = new MonkeyRiddleGame("""
                cczh: sllz / lgvd
                sllz: 6
                lgvd: 3""");
        assertThat(cut.getShoutingNumberOf("cczh")).isEqualTo(2);
    }

    @Test
    void puzzleInput_solve() {
        String input = """
                tsdr: 10
                smgn: dlzt * mdnl
                tlmc: qcff * wqzp
                ncwv: 2
                vfvj: qtjm + npwt
                qfls: 4
                gjht: 17
                dvzv: 5
                hghh: dprm * btfn
                ljjm: 4
                ldgg: vzqh - tjgz
                ddbp: lqqz * sgzq
                fgwt: nffj + nwsn
                tzfs: 2
                pdst: dvvl * pvgm
                rczv: 4
                sggd: 2
                wszd: tjjj + dsrm
                bnnp: gsdp * hgdw
                cnmc: bqzq + jtmp
                rtrq: vdbr + zmdn
                tlsz: gpgg / bbgl
                hvpc: 6
                tqml: 4
                trfm: jrbb / pmfs
                fhzr: 2
                qhhj: bcgb + bqfp
                jvmw: pfhw * ndmg
                pbwr: bsfj * chzf
                bbjf: hggs + vdqf
                lwmv: 11
                tblr: 3
                szsg: dfvt * qjsr
                dvbj: sgsr + bnvr
                vmcg: wgfb - sqlq
                srbb: 2
                qphr: pqgl * gmwl
                wcnb: 2
                pjht: 1
                mgzm: 5
                zbfz: fdwl + qppb
                gmnd: 4
                pjff: gtnh + hnbc
                spmj: 1
                wdgv: vfvj * tpbt
                spsb: trlm + rpcd
                smhl: 4
                tzqc: jdbv * jvjl
                djgv: dtbl * hqcl
                lnzh: 3
                dtpl: brzg * zjdm
                njdg: svpw + vttz
                tfcc: 2
                bthb: wcgm * rbfp
                glht: qchb + gzfq
                ctms: 2
                pffp: 16
                wchf: tjtb + wwml
                vhnw: cllt * vwfq
                sqmh: 5
                gsss: qfvq + nrcn
                rsvv: 15
                qfvq: 4
                dftf: 2
                thtt: twfm + wgll
                brds: qslf * chhb
                vwtd: qsms * jzzr
                wrfr: wgph + rzqv
                sgcq: 3
                wqww: 2
                wwfn: 13
                rqvv: 2
                pwpc: lfdz * jfdb
                hrhn: 4
                vdvg: dvwm * gmfn
                qmvr: 5
                zwww: 3
                hldc: gwlb + vmlh
                fbjz: 4
                brmj: ldvt * rptr
                dvwm: 5
                ltsw: 7
                gprj: gwjh + chlt
                pvjm: 3
                qqbs: 2
                bqzq: cwjn * dzzw
                qldl: 5
                zjbg: ljrf * svfv
                frwj: dhgv + rflv
                vnbl: 2
                pnjn: tmrl * tclc
                flgv: cdcv + ztgj
                tgqh: wpmz + nptv
                ljmt: 7
                mpdg: bchp * ccts
                bsfj: 7
                zcqt: 3
                gwlb: sqbf + hqtc
                trpz: 2
                gsrd: 11
                rzns: dlbl + qdnb
                hhwj: bgsn + qfpn
                zpgq: 3
                lfgt: lrth * mdnm
                zgqr: nmcr + lcgq
                wswg: 3
                vtzf: qbqj + prgt
                nzhm: frhv * lhzh
                czzj: 4
                zvcf: rcww * dcsp
                crwc: csfw * rqbl
                qqql: 5
                dgcj: wfzv * ngnz
                wvgf: 5
                mqmr: 3
                rvdd: tqjj * dvnr
                dpqd: fhfh + whtb
                psfc: vsrh - dwbc
                qzbn: 2
                jndn: 2
                rccd: qhcj * hffd
                pcqj: 3
                sbvb: 2
                qcrd: 1
                rzcn: qzwm * mzjp
                jhwj: jzcc / wvjb
                hgfs: 2
                nhtw: 8
                hzwt: 5
                htbq: 2
                hnqz: vcgl + rvgr
                wfnb: 3
                zdcc: lhlh * pwhr
                wdzt: llsl / mrhl
                zhvg: mhmw * wffr
                hmqs: tzvn + hhld
                lfqr: 5
                qpcd: wgbn * vnnb
                mdnm: rwdf + jvft
                hdrm: 2
                brwc: bhdb + gdmv
                rvms: cpwm / vhwn
                mvgt: rzpp * rwsv
                ggbt: dlrw * vnwb
                ftvf: 3
                btvd: 2
                zfrf: 7
                bhtz: vvbh * gpqg
                zzvq: wdsj * rzzf
                gmwl: 2
                mdvw: hwsr + glnz
                nvvm: lnbt * wcnb
                mrmv: 3
                ztwt: qlfw / nzzc
                pjmn: zmqr + zljr
                qrpr: tghz + qnsf
                qlnv: vzsv + zcvt
                ddlj: dfsj / tblr
                sbpc: wchf + wzjc
                lrvt: scqz - thjg
                gdgh: wwph + ddpc
                vvjb: mmps / mfnw
                fpcd: 5
                wglf: tgjb * mglv
                prlb: vlrc * mhrs
                vttz: 7
                zjds: zrjg * vncm
                zcqn: zznh - glfp
                lbtb: 2
                zjnw: hqjz + hqlg
                wpmz: cnst + gqbh
                lbnn: 5
                pgcv: 4
                ghjq: rmfb * blqn
                hntd: rvjn - bfbz
                zqsb: pjnt - fwnm
                pjpm: nvdh - wtcg
                jlcj: 4
                svrj: 5
                hqfp: 4
                mpcc: 5
                vggp: 10
                lsgc: dwrv * rnsj
                wjww: fsvr + bmbg
                rjvr: 5
                gdcj: jqlz * gngh
                qsbs: 2
                rwvv: fpcd * bzqn
                sdhb: sgcq * lddf
                nzsg: 5
                bmwm: cwgh + pbqm
                hhld: cnmc * fpfn
                fswd: jtcv * hqfp
                rqbl: 2
                mrdj: 1
                vmqv: szfm + cnjd
                fjfs: qpsn * pnfs
                zfpl: 3
                lpsz: 3
                wmng: zsjr + fjfs
                tjgp: 2
                mdjc: 4
                wgfb: vprw * glhg
                pjrj: ncdv + shcc
                stgc: dmqn * tfsf
                cllt: 5
                jgtm: 2
                tqrs: 3
                qhct: gvnt + wjns
                rlvh: czlz * qrpr
                mncm: 5
                fgfw: 4
                nvwf: hjqj * swpt
                csqq: 5
                mdqq: 2
                tmjf: 5
                vghz: fjdf * pdqj
                cpfl: 2
                lvjn: 2
                jmrl: 5
                vffv: 2
                chzq: tzqc + gglj
                qgwl: 3
                gwnn: fnqj + jmjg
                frmc: 2
                mvnz: 13
                pjnm: 4
                gcph: 7
                qqlt: 3
                smnw: 2
                nvbc: cmmd + dsrd
                bnbj: 2
                thpb: dsbl + qcts
                gtns: brds / frmc
                cwfh: 9
                jtwm: jqcb / wfwm
                sngn: mdwl * ggbt
                bnqf: 2
                rhdd: lsgd + mftd
                bggm: crwc + fzqw
                nsnd: 3
                pzvn: vltq + smhl
                trmj: 4
                vfgj: 2
                jvjl: 4
                hpjc: 13
                pgpm: 3
                gnsr: pcvz / pflt
                fvsm: mwtq * wtvn
                vmph: htnn + ppgl
                vvbh: 3
                hdzd: szrj + fqmw
                cfhd: htvh * czwb
                mhpq: jsrc + ccmr
                nvsp: fgfn + cfjl
                mwtq: lmsq + hmqr
                msnv: 5
                qbtz: 4
                qncf: 2
                vwzr: 16
                bzll: 2
                nzvd: dnzn * chfh
                twpb: vglt / gzsl
                vzrv: rsgv + ghvv
                gbgj: 3
                fdbh: 6
                fngp: ntvp + qcfp
                sjpp: 2
                tjnt: mcsr - rlgw
                tzpb: gnhj * qpzm
                qnps: 3
                lbbg: 3
                ccsw: 2
                ddpc: 4
                qcts: 19
                qgww: ddts + btbn
                fctp: 17
                dqtw: 1
                fcpf: 1
                gdsg: jfrq * qtzj
                mtbc: 2
                vmsg: nmnw * mqtd
                tbqw: 2
                mzhq: 5
                hbwm: 5
                chzt: 2
                swpt: 2
                jdnd: 2
                nwtw: 3
                sfnz: 3
                lhvs: gtjc + fpjr
                hnbc: 8
                ncbf: 7
                mlnf: 3
                bbgd: 6
                dpbm: 5
                vdvl: 2
                cfrh: 3
                pbpq: clll - rhlz
                ftsw: nmtd + thjz
                rvqp: zmdl * cjhh
                zbsc: vmhq + jtwm
                dvqt: 4
                stnw: 5
                dtmj: fbjq / hdls
                ghwc: ngvw + sqcf
                bfqv: 6
                htlr: 9
                trmh: 2
                zjlq: qmvh + ddqm
                llms: hvrj / bzll
                rlls: gwpw + gqdf
                qpfz: 5
                cwgh: tvhh * vbbd
                rwjl: 2
                cczd: 2
                ljsn: 5
                rltt: 2
                cgpg: 3
                pvhw: bvss - wswg
                jwtd: 18
                flcs: wwpr * zfbd
                sgsr: 1
                zwfq: 2
                dfvt: 3
                tqdn: 1
                plpr: 2
                mzvq: vcvv + tspj
                zsjz: pjlb + dzcw
                ccts: 2
                jtzb: czqn + djjj
                vmms: lbcb + pvcn
                llpv: nbqz * tcvm
                pbdh: mnjb * cqgt
                dfsj: wbmt - crrz
                vmdf: qmws * pcjm
                tmlb: 7
                hnjv: 11
                zwgf: 5
                htvw: 2
                wfzv: 2
                dbbl: pzvn + ltjn
                qdsq: ttbt / ghlc
                pdqj: zdqw / gcps
                mspz: 12
                qmws: 4
                dhsw: hdzd * jmwf
                nplt: nbrn * vmsr
                bmww: vvqh * rcnh
                gjgv: vfcg * hwwb
                hffd: 2
                dttd: 6
                bhfd: zcwv - nbtc
                ljrc: rjtz + vnqz
                smvl: 2
                gqbh: scbb * fbsl
                mbqc: nszt * ljmt
                fgcr: 3
                gwjh: 18
                trsh: nzgw / hdrm
                zncs: 12
                zrwm: lhzg * glnh
                scbb: 3
                cnst: dqnl * pwgr
                zwtc: rvfc * zgqr
                dssz: dhsw * bvtd
                tpnc: 11
                zhcv: 2
                psrv: 5
                jrbb: gdsg * rnwf
                hgzz: qjwm / tvvc
                nwsn: sprv * cnzt
                czdh: 3
                clgb: 3
                cpdv: hlfh + csmw
                dlzt: 3
                qmfj: 2
                gpqg: 2
                dsts: 3
                vnwb: 3
                zjmd: 2
                cfwc: qczw + nsll
                gzvf: mjzh * dpqd
                rfpm: 3
                trqn: qcdm * cdlr
                wccn: 2
                bfhv: hsmm / wlbf
                gcpw: qbbm / cgpg
                gjmp: 2
                vdfh: chqp * wzrm
                mztr: 3
                plrb: mztv * thls
                nfjf: fvts * nvwf
                wwhl: hlfr * nshl
                vfpm: 2
                sscf: 3
                gvnt: lzvv + wjfd
                tmwr: gwnn - zqpg
                vfpp: 6
                sddl: 4
                vtjv: 2
                chdl: 1
                nvdh: dqnb - vbbn
                bgqp: 2
                gqnt: 9
                fmrj: 12
                mtqw: zjjb + ldgg
                lccj: 17
                qhvq: 5
                ggbg: 1
                mqlj: tbnt + bbts
                vwmr: 5
                tgpl: 12
                zbdq: 5
                pqff: 8
                vmqd: 10
                cvhm: rclp * qhvq
                dzdv: lvln * rhhf
                fqdh: zqzr + npzg
                wrfh: stlq * dlqj
                wwml: thrm - hggb
                ncmh: jrrg * cmnr
                jcbp: pgdt - mvzv
                fmzq: 2
                qwnt: 5
                nmrq: ffsh * ctwr
                bllc: 2
                pqdh: 16
                lfjc: 5
                mdlj: sqlj * zffh
                hqzc: 15
                bbpz: tbqj * gwhp
                jghq: qfls * lmrr
                qrdt: 4
                rzsh: 4
                qcqz: 3
                jtcv: 2
                nrbh: tqdl * qncf
                qttv: 2
                humn: 608
                pmlc: prtz * stnw
                qngh: rslc * slrm
                llsr: 3
                hlts: 18
                fmvv: 2
                qcbf: zgtj * grdw
                cznq: cpwr * zjzj
                bjvd: bhcd + wmzv
                bgqq: jlrp + hlts
                vqbh: lnqj * nsqg
                ztgj: gbwj * brts
                cdlr: vgmc + qtdr
                tsgr: 3
                slrl: 5
                ssdh: ftsw * dbvg
                htbf: 4
                fmqr: 7
                hvgp: 14
                hpsw: wsgq * hwhw
                chfh: nszr - nccm
                sdbl: 4
                gvrw: 2
                pcwn: qzrf + qgbn
                prtz: 2
                nhfq: 7
                cmqb: sqtf * wffm
                vlzw: btcm * dwdd
                hlcp: 10
                mhwr: 3
                ctlp: znwc * mtgm
                dhct: tzzs * lpcz
                brts: rqjm + zhvj
                dmcf: zdmq + vppv
                vdgc: vchd * gvvl
                pmvm: 17
                cdbm: 11
                bqjj: hhml - fnjh
                lbgs: 3
                hgvg: fsgd / cbpz
                gqqq: 4
                tzjt: qvtd + tlgn
                czwb: 17
                pcps: msqf + dzjp
                dhgw: 3
                ftnh: mqwl + wndc
                jrtd: 3
                rqpw: 6
                tmhm: 2
                bjhg: trwq - hlcp
                zgzs: dbdd + gbgj
                fhnn: lvjn * wmnw
                vpdq: 2
                hmwc: jwpq * dfhb
                ntvp: 5
                thqh: bmdf * zqsb
                lnqj: 2
                wgwn: cddj * mztr
                grdw: 2
                twfm: 3
                zwjb: bbwt + wrsz
                fgvd: 1
                vztr: 2
                nqfd: ztsz * dgcj
                vzhc: pcps + rvdt
                zvwt: dhgt * zpqg
                phtf: 14
                nfhl: rgnn * zfdh
                rqjm: bzss * zstf
                qlff: wfnb * szbh
                cgzz: 2
                lsgd: 8
                lqbh: 7
                rjmn: dcqh * qpdq
                zlpr: dqbp * fsgn
                gnpp: mtbr / dfvb
                ztlt: 12
                dbdd: mnmj * wtds
                ntfh: wrnn * scvm
                thrm: wmbz * trmh
                rzhb: hpsw + rgzj
                tqhr: qcbf + hdrq
                jzcd: zhmz * ccsw
                jcrr: snpd / psfj
                vqjh: jczz * gzmd
                cltm: 4
                hmzj: tpzb * qgfl
                rqbt: mlnf + cbfm
                szfm: mbdv * mghs
                szzq: 2
                mdnt: cgqq + gddw
                mtcc: 4
                gnmc: nhfq + hwft
                jgmh: sbjq * rzgt
                pzwc: qqhb + psfq
                nshl: 6
                ncnl: 5
                pqgl: 6
                ndgm: rsvv + smgn
                ltdt: 6
                pbgh: rvqp - npvw
                tvwc: wnfn * qzgr
                hvrj: gmgj * vnjf
                nlvr: 2
                rmvj: rsqv + lltg
                zznh: sslt / rjzc
                bnwq: 14
                tqdb: lpbb * vmph
                mhmw: qmcf * jgtm
                bvlz: 15
                tvpd: vwtd * mfsb
                ntpz: 3
                lcnd: 2
                rjwz: 5
                bwlm: 3
                fqwj: 2
                cglp: lhqv - lhwl
                fqjm: 5
                zcvt: swcz * qbtz
                dvnr: 2
                qrzl: jdmh + zvnv
                fhfh: sjpp * wmmj
                crsc: jbzr + wlph
                ldwd: 2
                pjgb: 3
                zcwv: hzwt * fprh
                trtp: jvrt * zrjd
                vwfq: 5
                stvr: tftn * fmpj
                zvdv: jwhz * rvzp
                zpqv: wqrt + wqzf
                vzgf: nfnn * jqlb
                fqmw: 8
                ppls: zpqv + hvgp
                zqpg: 3
                hqjz: 1
                mwrr: jfpm + gtns
                jddv: rcdn - fgqz
                vvgn: lmlb + zbsc
                hqtw: htcg / mjqs
                wvvw: 3
                wsnn: 5
                ldhq: nfzz + lppd
                fddn: qspz * tgqh
                dhnb: 3
                jrcw: mwrr + bqjj
                jzzr: dvgf + mfvl
                pmqf: cmlh * gfqm
                vjtc: smnb * grmr
                bbts: 5
                djnv: 17
                ssbj: qswc * rjcb
                hhbp: 4
                pmnt: phwj + rvdz
                dndr: 2
                zqcj: svrh + nrmw
                bbbf: 13
                pflt: 2
                zzlj: 3
                gbjq: gltt + ddlj
                tlgn: vfpp * vgnz
                hhtc: 2
                qlgq: 2
                bpwp: jgdr + htzc
                rpcd: tgnb + cpcw
                cnmp: 5
                jsrz: 7
                zstd: 2
                svdg: 2
                tjhv: dttd * vctr
                jbzr: zrsg - rpsz
                zfcd: qfpl * qqlt
                jzcl: 2
                dzhq: mbvb + gqnj
                qpwp: ghcm - tnsn
                sjbc: 11
                jzhv: mnzz * pgbt
                cbdd: 2
                pzfw: 5
                lgbw: 3
                wdsg: lwmv * mlqd
                lrdl: ncmh / dnhl
                wsgq: 2
                sqlj: rjlv + thzt
                cmmd: qhct * bwpd
                rzqz: ppvj + llms
                qwtb: 2
                dsrd: twpr + qwqv
                fvrd: 2
                mmzw: dhnb + fffs
                prpp: rwtn / jgnd
                cmbs: czjz * qtvs
                mpng: 2
                qvwr: 5
                pvlf: 3
                ftfz: 3
                jfpm: jzjd * htcs
                szzh: 4
                wqrt: ppqw * jchf
                wlbf: 2
                fbsl: rqhp + fmvv
                dgqm: vqcm + vgwn
                bcgb: nvsp + cnmp
                hggs: 8
                cmwn: hhwj * jmnp
                blng: 3
                zsnb: bwmm + fqdh
                dsnq: 2
                cbfm: tfln * hfgd
                rdbh: 7
                tldz: 3
                fctv: 11
                mgtr: 4
                jqsv: zvzt + nmlw
                wtcg: ffvc * vbsl
                zpbn: 2
                sbpf: drwv * ftlv
                vvlb: chdz * jqvg
                vppv: 3
                gsvs: 2
                cqgt: svcw / clmz
                cznl: 3
                wtvn: 3
                ddbb: 3
                sswv: vhzf + sndw
                dvjs: 6
                srwg: 2
                pjlb: 7
                cndg: 13
                qvgw: 3
                dnhl: 2
                nbrc: 14
                pfqw: 2
                trwt: fdwz * mblj
                dfvb: wnwd * dlpg
                djwz: dhhm * dddb
                hwzq: jzhv / dslf
                ctmw: dbwp * hbwm
                rvdz: lhcr * rndz
                qchb: qhhj * bsfs
                vdqf: cqtd * vczj
                czcn: 5
                dlmg: ctmw - tndn
                djfm: 2
                czqn: zdcc + nzjl
                qbsq: rzsh * psjm
                chqp: 3
                nzpb: 2
                vctr: jdht * dgrg
                gscn: 2
                fzqw: 1
                ppsv: rzng + csvh
                vjsn: dhmg + cmrm
                pmhz: 7
                lcnn: 14
                rhcf: tznm * wqww
                vmds: pwvq * grgt
                mmbj: 2
                jmdp: tfgp + vbfn
                tlwn: lvvb * wvvw
                sbbw: hgsq + wmng
                qttm: 2
                brhl: dbjj / ddsn
                ddcm: jrcw + pjtj
                jcpd: vdvl * dszv
                tlsr: 7
                nszr: nzqt * bgqp
                fhvm: 3
                fbjq: qllm * gmvc
                bzgz: 5
                ztfc: 4
                qnsf: fsfn + wwlq
                bbwt: 5
                hjcc: 3
                wqzp: gqqq * dhwn
                mprb: cgcr - jmfh
                qsrl: jlrs * tvwp
                hbpw: 2
                hwdj: 1
                flmd: hgcp + pbtl
                wrns: 8
                shms: 3
                jslg: stcg * hbpw
                nnhw: 4
                ljrf: 2
                gmfn: 3
                hwwb: 2
                sflr: mwff + fdsm
                wjjl: 2
                srrn: zfhm + ghcb
                lvpt: zstd * zntn
                glft: 7
                qmqd: 5
                gvzj: 2
                szzv: 3
                qtcb: 3
                cmrf: 3
                wdpv: 18
                mvzv: lvwp - vmcb
                pnsf: bpqf * ctsg
                tjfp: 2
                qtzj: 6
                bjbz: pdqb / zjmd
                vpzt: 1
                zjzj: 7
                vsgh: vqwd * mdnt
                fdrg: 6
                fwrv: 2
                ctmf: 9
                bccw: btpw * mwsh
                jlcd: 2
                hssw: zfpq - tmgg
                rbms: 5
                hpjn: 2
                jdpm: gjts * dprw
                grmr: 2
                jrwm: wtrl / swsp
                rfwt: 2
                rmfb: 2
                rvmr: qcrd + fcwf
                mtgh: cjvz + lpgt
                wsjn: 5
                rpzw: bccw + sqdd
                bbcj: btwf - mqlj
                ttnt: zzql * fgqj
                ddrb: 3
                wlvw: rlss + mltv
                mtdw: pqnw - nhtw
                tgtj: 5
                hcmj: 2
                tqpv: 13
                nwcz: drhn + vjzs
                hgjm: 2
                gztm: 7
                dhwn: 2
                mzqt: tsng - nwgb
                mmjh: rqpg * djvp
                gcrd: cvzb * ldvr
                zrjg: 4
                tcvm: 18
                hhml: cpdv * rzqz
                gfcz: tbqw * tgtj
                qbdn: 2
                vhrf: 8
                rpwd: gshz * dgtp
                hhwd: tjgp * bbjf
                llqd: jllq * cjcg
                sqzw: vcgr + fpgh
                dgrg: 5
                dbjj: wvgf * lgcf
                svrh: 10
                pfhj: 3
                flfr: 2
                mhsd: vhqg + zphj
                vwrh: qwvl + jmnj
                cgcq: srrn + bpwp
                hgcp: fndh + tldz
                jcgc: qczg * nlzp
                fgrb: ctbl / hhhn
                rflv: vmdl * tclr
                cwtc: mdvw + jmqh
                chhb: 2
                gzfq: rvdd - bwgv
                fjsh: 18
                htcg: jdwr + nvlj
                pbrf: 4
                lfqt: 16
                wzrm: 7
                jmfh: bjtm * zfqc
                ntjq: 3
                tbfq: lrvt / mnzw
                hcpq: njst + bbth
                sqtf: dfdf * hjzm
                rwdf: 11
                hgqs: 2
                tgvp: dhjg - fpbm
                vsds: bwdn + rrmw
                vmsr: jrsq * lqjf
                zcjl: 7
                wjns: 2
                pzrt: 2
                mvjg: znsn + sscf
                frgp: dpcr - jndn
                gvbq: 3
                pqnw: bslw + rhdd
                lnjm: trsh - wlmp
                zftl: 17
                sdlc: gztm * dsvp
                mfvl: hgmm + bnrm
                sgzq: plpr * jhmj
                jczl: 7
                hcbf: nfnr * mnpg
                lpcz: 2
                bbgl: 8
                fsvr: 6
                lmvh: 2
                tztp: 4
                wcqq: 1
                qtjm: tgvp - wgnj
                wlnr: 2
                fpnw: qsvj + pqgw
                cpwr: wtst - lpgw
                hggb: dqqr - qngh
                nznw: cwfh + jcqr
                mghs: 6
                sswn: zdld * jjgz
                dhhm: 15
                fpfz: 2
                msbc: 10
                tcrt: mzvq + rzhm
                crrz: dfhs + ttwc
                mjzh: 2
                wflj: 3
                scqz: fhzr * zcqn
                gcjc: 2
                sfpq: 2
                rjvb: 3
                fpsq: mtdw + ghwj
                jpzj: 16
                rzzf: 18
                qzmq: 8
                dsct: 3
                vgvz: 3
                qppb: rhcf + jgwc
                zgwv: 3
                lhwl: 2
                fsgd: hssw + djrg
                wbmt: sbpc / vmcz
                mvdv: nfnl + rjvr
                lgcf: ndgm + zvdv
                mrtb: pffp + zpzh
                mhml: 17
                pgtm: nzjf + ggcc
                tllm: 4
                bwjn: 7
                sjfj: 8
                pvjn: bbbf * mmbj
                wfwc: 8
                qfll: 6
                fprf: lpsz * bcpz
                tfgp: ptjt + hnjv
                ggjl: jcpd * dvzv
                bdpp: 2
                qlzl: tzpb + sjjj
                nwqq: jslg * vdfh
                gqgq: mmzw + qrtp
                swsp: 2
                qgcr: fpfz * bhtz
                bchp: 6
                rqpg: 2
                lwvz: fzwn + dvfz
                qfbg: ntdw + vmcg
                gqtc: blvf * vpdq
                bglt: 3
                hcfg: mvbl * sbfp
                hjgt: 19
                vlcs: 7
                qswc: 2
                bnvr: qmfj * qrhp
                pcfh: 3
                vprw: httd + jgmh
                mgdp: 2
                gmcj: 3
                bwlf: ljsn * pbpm
                hqlg: 6
                cnpb: wvst / cngl
                qcmb: 12
                njvq: bfhm * rvpd
                zvgl: bjvd + ghwc
                hjzm: 3
                qspz: rhsv * tzfs
                dlrw: 3
                glfm: 2
                mdth: jwjd + cvhm
                rpcw: 5
                jqlz: 4
                rfsf: 5
                jmwf: 3
                hwsr: 4
                gwhp: czzj + lmtw
                fvss: vrdt * wrns
                djvp: 4
                dpdj: zztr * szjh
                ngvw: 9
                qfzh: 3
                mbgp: mfvn + jjzr
                rhmq: 4
                bwbq: 2
                blvf: 5
                cfqq: 2
                psjm: 13
                tfhg: 2
                btls: 16
                fdzw: 4
                dlqj: 2
                gzgm: wmzl + nqfd
                fcsm: 1
                bvtd: qrzl + tvvl
                rzst: flfr * pvjw
                dgdf: rcrd * qcvw
                jchf: 2
                qhzz: 2
                bvqf: qmww * qpmz
                sbbt: humn - ddcm
                mmlf: sqzw * fcfq
                jphl: 3
                jspn: 2
                fvbn: 19
                jntt: zshv / jwwm
                tzzs: 3
                fnjj: bnwq + rprw
                dgtp: ljtm * rwjl
                vlrc: 3
                gfgz: 2
                tlmn: 2
                pwvq: 7
                sprv: 3
                gnmb: rhmq * mltm
                gtnl: 13
                sgsz: 2
                ngpz: jqpw + phtf
                vvqh: cmwn + bljr
                wmjn: gtfv + lwfg
                bszj: 2
                dlbl: zpjz * rqbn
                wtds: 8
                bfhm: 3
                hmfg: tvpd / mgdp
                zlrr: 3
                ghcb: wnmq + vzvb
                pgts: 6
                fbrs: dfdc * ddbp
                qhcj: qhpb * gvfs
                tcvb: bhsm * bdmd
                ttbt: ccdv * clgc
                wdsj: qngp * fgfw
                hsmm: zptn + bvvw
                swdg: 2
                mjtl: 5
                pwgr: 2
                qtvs: 4
                bpbn: rdbh * ctqb
                tgjb: 3
                lbjc: tvsg + zvzb
                mcmz: sbbt / thfl
                pqpr: swmb - vdhs
                ctdh: hvrh + zmwj
                fpfn: sflr - djwz
                pgnh: 2
                lpgw: lbnn + jnjw
                znbd: 2
                nptv: jzrh + rtcf
                wffr: 2
                nclp: 10
                pbvv: nsng * rmqw
                qccf: 3
                rpjt: 3
                jrsl: wlnr + brwc
                rndz: hjdh + hwrn
                zpmh: 3
                ldgm: 4
                mcqt: jrwm + grzz
                rfbp: 1
                bhdb: 5
                qljh: 1
                smzq: 2
                lznd: rjvb * zpmh
                nrcn: 3
                jlqh: qrlv / vnbl
                jcpl: frbr + qvwr
                gftl: 5
                fdvv: 2
                zrsg: ccqw + fgrb
                ncll: sswn + nrdl
                pnfr: 5
                rwqb: dswg + vzhc
                ncdv: fwmq * jbsz
                tzmd: 2
                cgqq: 1
                vmcz: 11
                wdzp: 2
                rbcn: 2
                hztw: cczd * mncm
                ztqm: pcrb / rnjm
                pbpt: 5
                vbfn: ddrb * rpwd
                wrjp: tbbf - prpp
                mslv: fswd + zqcj
                jtsc: tvwc + gdvm
                rgff: 5
                qpmz: 7
                ptjt: cfmp * jsbj
                dclz: rlls * csqq
                wppp: zvcf + jqsv
                fffs: 3
                nhtv: 5
                qlzf: fzlz + zrbr
                mrsw: 3
                dbfw: 5
                bwlw: 2
                dnpr: dsct * ntjq
                jtjv: wrmt + fbrs
                vmdl: gfcz + dqtw
                lmpn: dmln - zsnb
                qcnf: 17
                pzsn: 4
                fzfq: 4
                wjgl: 8
                vcgr: zdcv * zwgf
                ffsh: 2
                mnzw: qpcd + bppq
                hvlf: 3
                sslt: rcdv + ccdr
                jzjd: 9
                vtbn: vpzt + jzvc
                gdvm: pcqj * hmhr
                cbhn: 5
                grgt: rrvh + wmjb
                ctwr: ljrs + rsqb
                pjtj: vggp + btqp
                lsnn: wnqf * lbgs
                svbr: vvpd * fctv
                dttc: 5
                mlqd: lmsv - sgnq
                mglp: cdch + dgdf
                bljr: dgpq + vgnc
                jwrb: brhl * ndqh
                wcbd: 6
                dvws: 19
                rqhp: vncw * gwst
                qbtn: 4
                tnlb: 5
                fhvf: 5
                jrsr: 2
                qrjg: 17
                gdrm: 5
                gtjc: bsbm + qlzf
                mvbl: 5
                gmhz: pjht + jcrr
                qcdm: 3
                qbvl: 2
                pjnt: trqn - hbfc
                jnjw: 2
                mjsv: qwnt * rptm
                qltf: 8
                lbcb: jwrb - thbr
                qmpm: mdnz + bvlz
                jmnj: 4
                hzbw: jcnd * fvph
                gdmv: zbwt * jgtg
                sdft: mmmw + wbhf
                pbgs: 2
                mqmg: 1
                ctsm: rzjs * cwtf
                ptvp: chdl + rjwz
                pgdt: sdft / bsml
                jsdq: nmrq / pgrv
                flvf: dpdj * zjnw
                fwdz: dvjs * ztwt
                fqbh: gfmz * ldmn
                jvrt: bdrz * tjph
                pcpf: 4
                qtdr: 2
                jzgf: cpwj - wjgw
                znzb: 3
                drwv: 11
                wfmh: ncwv * tqpv
                smfh: qfbg + hmqs
                jdmh: bcqh / wsnr
                qpsn: 2
                wvst: mvlj - vvjb
                lftq: zhhf * hgzz
                ccjp: 2
                dfbf: 2
                clgc: 2
                rslc: gsvs * jphl
                qqhp: 3
                mjqs: 2
                zqrq: swdg * dzdv
                spml: 5
                zptn: lnjm * tfhg
                ttpn: 19
                mpwq: 3
                thvc: gjgv + wddm
                cmrm: nhrb + cgqr
                lmsv: wgnd * wmws
                lhcr: gptj + mbgp
                bdzh: 2
                jzrh: mdpz + lzbf
                rpsz: brzd * llsr
                jvft: hlzd * rnsm
                lnsb: wjww - czfq
                zztr: 5
                mmzp: 5
                ldvt: 4
                cpdp: 1
                jgln: nrbh + qmqd
                mgzr: gngn * mpdg
                cgcr: rnbg + dnmz
                dcgh: mvjg + pnfr
                dmpq: wjhw + dpwz
                qtcc: 1
                fnqj: rpbj + ggjl
                wjfd: 2
                vjgn: 7
                mtgm: 3
                pbtl: 5
                nrzt: cmbs + pwpc
                nrdl: qrzj * thfc
                dsrm: hzhl / bcgw
                rzbv: 4
                wmjb: mgtr * wcbd
                wtrl: vfpm * pmvm
                cfjl: 4
                ddsn: 5
                gdcb: nctw - pjnm
                ccmr: nclp * ctgs
                lqjf: rtrq + psrv
                nsmf: 2
                nmnw: nlvr + rpcw
                jwjd: 16
                tglm: 2
                whtt: dvws * jqcr
                fmgq: 1
                mvsr: vmfl + trfm
                dbgj: 2
                smcg: 5
                tjph: 3
                pcrt: cvrn * wqcj
                wmwl: wjdc + nwqq
                clll: shpn * qbmr
                rsfd: fcpf + qrlj
                gbnq: spgv / wrhf
                hwrn: pzrt * zwdv
                nqvv: 3
                wwlq: 2
                ndlm: mcrv * rrbq
                qsnj: 2
                vnqz: 4
                jdbv: 8
                qllm: lcjs - zbmv
                qgjb: 8
                rjcb: 3
                cdcv: lclg * dtwf
                zbwt: fpjg * smvl
                nzqt: 5
                lpqp: 3
                zqtp: spml + tzfm
                glnh: 3
                jdht: 2
                vzqh: ppsv * gvzj
                qggs: ccjp + ncnl
                cjnr: mhwr * nrwd
                ngbt: 4
                zmbv: 3
                qzwm: vvbg * vcsf
                pwfw: mhpq * sqmh
                sqdd: fzgs * gblp
                lzbf: qgww / lfqr
                dlgt: qhps - bjhg
                gptj: rhzn + nbrz
                ntzr: 8
                szlv: 2
                znqj: tgwn + qgtg
                cchj: ftvf + qltf
                gsdp: 2
                bgsn: 4
                mmmw: fpnw + hqlp
                ddmm: tllm * mlzh
                sgrl: bglt * qbgt
                wcnf: bvlg + gjfb
                pwhr: nzvd + lzql
                wnqf: 16
                nmzb: qmpm + pmhz
                bmdf: msfj * ldwd
                bbcl: mqmg + pqsr
                ssch: fqwj * wnlp
                lgws: pwsq * lhvs
                zfqc: 2
                zvsf: 3
                rgtr: rpzw * mjcd
                svpw: qnps * htbq
                dmqq: 5
                bfbn: 2
                bvss: ldwc * qccn
                htdb: 2
                qtqs: 7
                wvjb: 2
                wncq: tljd - jfjg
                wtmd: 4
                mzjw: tfcc * frgp
                fjhf: 5
                bbdn: 5
                tbbf: zqrq + hwdj
                nsqg: pwdd + pbwr
                pmwn: zvgl - sngn
                cscp: grzm + vjtc
                shcc: rszt * wdpv
                sbjq: ctch * jmwm
                jhmj: 4
                jlrs: dftf * nwtw
                tspj: pfsb * fpzr
                pfhw: 3
                ztcl: bpnj + hvpc
                httm: 8
                jcpj: 2
                pmrw: 5
                ndqh: 5
                qfpn: 4
                stcd: 6
                wcsz: 16
                fbhw: 3
                nrwd: 2
                ppvj: 2
                vhmh: 4
                qpgc: zqtp * rqjc
                lmtw: 5
                dcqq: 2
                rczz: jsvl / qtcb
                nffj: 3
                lgww: ftfz * fvbn
                djdv: 2
                dwrv: 11
                bmdz: 2
                gsqc: 4
                rsfz: tcrt * nfhq
                dswg: gjht * nsld
                sstf: vbch + wjht
                vgnz: 20
                jcqr: 2
                ndtg: 5
                bhsm: 4
                fnjh: mdjc * qsbv
                wcdj: vjhv * httm
                zdqw: llqd * vsds
                dfdf: qhzs + lcnd
                lcnz: lbfb + ljrc
                wnsv: 9
                bsrv: cchj * vrwg
                wnwd: 3
                qczg: 5
                gqgh: 3
                fdsm: cqjw + qphr
                ldmn: phjw - hprm
                fcws: jvhs * bbcj
                lvwp: fhjf - mtqw
                vhwn: 2
                rtvq: bbpz * zgwv
                lppd: vgvz * htlr
                vdbr: 1
                vjvr: 3
                qsvj: vnnn / dbfw
                trlm: 1
                gbcj: ntzr + dfbf
                rvzp: rlvh / mnhj
                jwfn: 5
                qmbz: hbcz * smnw
                gglj: 4
                bjtm: 15
                rszt: ddmm * shms
                zwdv: gdbh * dmqq
                vwct: 14
                mpnw: 2
                gfhr: 11
                bbbd: gnpp + cjgg
                mbdv: 5
                bvlg: htbf * gmnd
                jtmp: fzwp * nqvv
                nsll: 4
                zmqr: lldj + wjch
                tgdl: 2
                dlpm: 12
                cffs: 4
                htfb: hghh + thdt
                rpjq: 4
                qhps: ppls * zrjv
                gjjl: bpbn + znrm
                njst: trdp * gvbq
                mbvq: 11
                pbpd: 2
                dwrm: 6
                dcsp: pcbj + vmcd
                sgdf: 3
                dwmh: 4
                fljj: 19
                wqzf: nzpb + wtnc
                qhmp: 3
                pvzt: cznq / zpbn
                htfq: mpnw * gzvf
                zvzt: 9
                lccq: wsnf * ntpz
                wcgm: 2
                trwq: lqbh * fjhf
                qlfw: dvfj * mvdv
                qhfc: 2
                djpj: vcjz + bvdc
                gczj: 2
                hcps: 1
                gpcr: 2
                crgq: trwt / vqcv
                wmmj: flgv - cttz
                fdwz: 19
                bfdg: fvss + qggs
                nwgb: 3
                chlt: 7
                nzbr: tlsr + grhv
                crwl: hgjj / ndcd
                cjgg: wlfm - mbfm
                drwd: 13
                csrt: gcpw * mgww
                tgvj: zfrf * lmvh
                hlwr: 3
                rpbq: 10
                nzjr: whcg + pcrt
                gzmd: 5
                htlm: wjfl * vhrf
                bcpz: 2
                tfsf: 2
                wvpp: mvsr * fdrv
                mvzd: 2
                zpzh: msnv * jnfd
                tgrs: jdnd + vdgc
                vfcg: dvbj + qngv
                vlrf: ppqd * qrbt
                hzhl: hrnt * hqzc
                rzpp: 2
                djrg: lgtv + wrfh
                dslf: 2
                tjbs: 4
                fvtw: rfpm + prlb
                jcdg: jrsl * ldgf
                qbwb: 3
                ppqd: 2
                rnbg: ttnt * bcgj
                ldnt: chzq - rjmg
                chzf: 6
                czcz: 11
                rhlz: nznw + bshl
                nmtd: vqbh / fdsq
                rjmt: fjsh + cndg
                hfgd: 5
                ljjq: 2
                pqsc: 2
                btvl: 7
                jzcc: rzql + jdpm
                sjjj: vqjh * vvnt
                vgmc: 5
                mlbc: vnsq + vnld
                bhlh: pmwn * dsng
                lwbc: 6
                qqqq: 8
                qcvw: rpcl + tqmw
                jtrr: gfgz * jtjv
                gmvc: rpbq * sbmv
                wlfm: nlps * wlvw
                dffc: pmnt * jchb
                gwst: 3
                pgfs: hvlf * fmqr
                dnmz: ccgr * zqvn
                tpgj: vfzs + rzhb
                fvph: 3
                cdhh: 4
                hwft: 6
                dqnl: jhfr + njdg
                hjmj: 3
                ctsg: nhnp * gjmp
                mdnz: blng * pvlf
                zmcf: rqlt + tdwm
                hpzq: 3
                jqnm: hjsd * mjcv
                vnsq: ftpz + fgvd
                szdl: 2
                bwgv: 12
                zfhm: tsdr * mgbw
                vvbg: 5
                msfj: fbjf + mzjw
                wgll: 3
                ghvv: 6
                nmcr: 2
                pdmz: 2
                gjwp: dwmh * dmrd
                phpv: 2
                lgtv: vhmh + vwrh
                zhhf: vzmb - jzcl
                cpdm: 17
                frbr: bfmr * hpjc
                vmcb: sswv * sdhb
                hcds: 1
                vzmb: 11
                dnzj: 3
                lrfn: vwzr * mdln
                nzgw: ddjr + dmtb
                dsbl: cjrn + ltdt
                rtrs: 11
                mbwv: mgzr / sddl
                mrfb: fpsq + cmqb
                hhhn: shrm + fcsm
                pnht: rfbp + qgjb
                gwpw: 10
                msqf: 10
                clrh: 4
                vcsl: 2
                hrjs: 12
                thff: qzbn * rczv
                cmsb: 13
                zmdn: 10
                pjqq: zrwf + wfhq
                pfsb: wrfr + wwlh
                qsbv: 4
                vmmp: bmds + fmgq
                fmqg: bhnh + cmvb
                frhv: 3
                mztv: 2
                tvqw: chrd + qtcc
                lmrr: 5
                tnsn: mzhq + qsth
                cmlh: cznl * clgb
                cqvs: qlvb * vczb
                dhnp: vdnr + rrvs
                qccn: 3
                rzsw: 13
                dlcc: nzdv / dldt
                jhjl: 5
                tvht: qsrl + pnsf
                ljsv: mjtl * slrz
                vtrm: 17
                pgbt: dtmj + wjjd
                mrlb: bhfd * pqsc
                qslf: nqbf + vtvq
                jzvc: gsqc * tbrh
                vplc: nzsg * tvqw
                qwdg: 13
                wmzl: rsfz + bhlh
                rcdv: vnrv * dhct
                rvht: vlps * rjmn
                qrlv: 16
                mftq: 2
                lrlp: chzt * ltlv
                dprw: 2
                fwnm: 1
                zfdh: 3
                ddjr: hntd + gcph
                btpw: qbdn * wmcf
                clbd: rqph * gcjc
                bgpc: 3
                rvfc: 5
                shzm: 2
                slrz: 5
                thjg: crsc - mrfb
                svbv: mvgt + pgfs
                jmqh: 11
                lwcm: bhns * bszj
                lwfg: vtzf * jppq
                wsnr: 2
                qdqj: 2
                jrrg: 2
                jvth: cmmb + wfwc
                znvm: 11
                znrm: vzrv + glht
                wjzt: 3
                mthh: 18
                pvpj: 3
                jwwm: qldl + czdh
                vnld: 1
                pzmd: tmhm * pcwn
                hjsd: 2
                rlss: 3
                nfhq: vfsz + bvnj
                wrhf: 2
                hfcq: 8
                zdcv: 2
                hgjj: pccg * vtjv
                wnll: btlj * pmtr
                wmzv: 1
                tsjc: lbfj * jfsw
                nnbr: 5
                ftlv: 2
                qmww: 5
                szsp: qdsq / vbcd
                nhrb: 5
                dfhs: gdcb * ldhq
                jbsz: ggjr - gqnt
                mqtd: 5
                zrjd: 3
                nwch: 2
                cpjj: 6
                tgdb: 2
                mwsh: prnq * fvbj
                qrbt: glmr / bbgd
                jvcw: 9
                cwtf: 3
                czlz: 2
                znvn: mgtm + zlpr
                vnnb: 5
                zjdm: 2
                bfbz: 9
                qrsn: 3
                rczp: 3
                jjcz: wsnn * lfjc
                dfdc: 2
                rzqv: 1
                qzgd: jpzj * dhgw
                vvtq: wsfr * fdjd
                thbr: rngd + jsnt
                sjtp: sgsz * nmhm
                ljtm: 3
                wmnw: dlpm + vmds
                sndw: 4
                wqcj: 4
                wrnn: gvnh + hdvs
                gvvl: 3
                gvnh: 4
                nwjb: 3
                fvts: 3
                rzqd: bfhv + gnbv
                czfq: 12
                lhzh: 5
                zmmw: tjnt + tgvj
                vbbd: 3
                tjht: 3
                qsms: 3
                wfwj: 5
                fprh: 11
                qmvh: zbdq * zmmw
                thjz: drgl * ljjq
                smnb: cpfl * rgvz
                fdjd: 2
                vczj: drzr / smzq
                nszt: 3
                sblh: fvfd * crgq
                nmhm: tzzv + bmvh
                rcnh: 11
                dzcw: 4
                mblj: 4
                pjtc: 17
                vqcv: 2
                nfnn: vglf * cwsp
                qvqb: rlbh + gjwp
                vhfw: nllp + hrjs
                trhq: mcmz + chhc
                nsld: 3
                bbth: 4
                jcnd: 6
                nwpw: jqnm - lggj
                bpqf: 4
                cllm: 4
                bnrm: nsnd * gprj
                bflm: 3
                mfnw: 2
                bzjj: 2
                vflq: 3
                jjzr: lbtb * cnrq
                brzg: 3
                wsfr: ctsm / zcqt
                qfch: 2
                bmds: rjfq * pgnh
                ppqw: 3
                nbjg: 2
                mcsr: bbcl * dtpl
                mglv: 2
                wjch: 2
                vncw: 13
                zjjb: qptn * dsss
                jsbj: 5
                cmfj: ztcl * hgjm
                fpgh: 1
                wddm: mmtt / bnqf
                scvm: cnpb + pwjm
                vlps: jzcd * mftq
                fwmq: 3
                zrjv: 2
                dpnz: 2
                jtnm: 3
                btsf: bvqf * sdlc
                cnjd: sgrl + qdsb
                tclc: 13
                drhn: snpq * wcsz
                lmsq: lltb + dnhv
                nvlj: qzlv * hhch
                gblp: jcgc + wnll
                zmqv: glfm + htfb
                dwbc: 2
                rlbh: glft * pvjm
                vvsq: 2
                vgws: qgcr + tnmf
                mltv: 4
                lhzg: 5
                hrdz: 3
                hprq: 3
                vwgm: sstf / jspn
                qfpl: 16
                tjsm: 2
                ncml: cfrh * jsrz
                rrqd: svbr / gscn
                npzg: htvw * tqdb
                cfvw: wtbs + qdqj
                vmhq: tgrs + vvsq
                cvzb: 4
                tjjj: gsdr + ncml
                chrd: 6
                zpjz: 2
                hlzd: 6
                mfvn: mpcc * ngdp
                cqjw: mtgh + dwrm
                lbfb: 4
                jcgf: tftw * tgdl
                jnfd: 5
                zzql: 3
                jsrc: vgws + gnmb
                rgtv: pbpq + thpb
                ddqm: jcpj * cmbc
                btcm: 5
                ccgc: fmrs + sbpw
                lcgq: vsgh / qbhj
                zbqg: hprq * qwdg
                mdln: 2
                qrlj: 6
                rccj: 5
                wndc: 3
                sbmv: 7
                gfcp: ttpn * phpv
                pwdd: 1
                bhnh: pvpd * pjqq
                jdbp: nfjf / cpgj
                gngn: svdg + gsrd
                tqmw: 16
                qngv: cdhh * vcvq
                dhgt: rrqd + vwmr
                tclr: 7
                dhjg: wrjp * nnhw
                vcbf: 1
                tpbt: czcz * jcpl
                dhgv: bjbz * pgts
                wjdc: lwcm * jlcd
                vsrh: qrsm * bflm
                vdhs: htlm * gjqc
                twmr: jlff + wphg
                lbfj: pzwc + qlhs
                tpgl: gdgh * pbpd
                tbqj: 5
                qpbm: fljj * rczp
                drzr: wnsv + scbq
                vcvq: 10
                shvd: cfnw * bcpb
                hqlp: ghjq + wmwl
                fwcv: qcgq - qqbs
                bsml: 3
                snpc: crwq * zsjz
                rzjs: pqdh + hfwm
                cmsl: 2
                fmpj: 2
                rmqw: 3
                dfhb: qvqb + blnl
                jmnp: 2
                pppt: 4
                btfn: 2
                mgtm: bzgz * mcns
                pmtr: 3
                zhmz: tdcf + lftq
                ddts: whtt * vhlf
                fpbm: 19
                vcgl: dhnp * fbhw
                rrvs: 5
                ljnz: pmqf + lccj
                fgfn: 2
                npwt: nwpw + shvd
                rvzr: fmcj * nhbp
                fgqj: 7
                vbbn: tqzj + dbbl
                bzcs: 2
                tcsz: 12
                sfgc: thmp / pdpm
                tjgz: jtrr / qsnj
                wfhq: 4
                wrmt: 3
                pcjm: hcfg / snfm
                hfct: 2
                vnjf: 2
                mgbw: 7
                nntp: jnsw + gjjl
                tljd: 12
                thmp: vfgj * pvjr
                nnms: jldw - gdrm
                djtt: 2
                lczq: htfq / cfqq
                rvpd: 9
                rhzn: qcmb * qbtn
                dlpg: 2
                ngdd: 3
                dvqn: hmwc + mhsd
                qhbp: 11
                wfrw: dssz - ndlm
                hmqr: ssbj + zczt
                rjtz: 15
                dqnb: ddbb * pjrj
                zsmp: 5
                fdrv: 2
                bzss: vjvr * mlbc
                wbhf: hgwv * hztw
                scbq: 5
                brjp: 2
                mwff: lbjc * lcdb
                gddw: qqql + jmmj
                zpwv: 1
                lhlh: 3
                qdlf: wndm * fhvm
                rwmj: dzjn * twpb
                bbfv: fhvf * wdnq
                qcgq: 9
                bdmd: 18
                fgqz: tmlb * nfhl
                fpzr: 5
                rnsj: 2
                psfj: 5
                ccdr: gqgq * nntp
                jdrv: hzjl + zbqg
                vjhv: 3
                ztsz: 4
                shrm: 5
                jqcb: fqjm * mmjh
                ldwc: 3
                qptn: 11
                vtvq: nrzt * bdzh
                tfln: 2
                bdrz: 9
                vglt: ljnz / cmsl
                cjhh: 2
                wjfl: 4
                fzwn: 4
                fjgb: 2
                snpq: nbjg * bwlm
                jnsw: qlnv / tsgr
                hwhw: 3
                mdpz: tmwr + rvms
                dpwz: 7
                hvgm: 7
                vhlf: qzgd - rltt
                hvss: 6
                gwqz: spfv + pqff
                wjhw: cglp + msbc
                zrwf: 3
                hmhr: 3
                vnnn: stvr - zvwt
                fzwp: vlcs * rmms
                dhcb: gqgh * rzbv
                grqj: 3
                vfsz: lfqt + mfjc
                qpfj: 2
                fmcj: 5
                gtfv: 4
                snfm: 5
                tgnb: 5
                ldgf: 2
                hvgg: 3
                thls: 10
                wjht: cbdd * ztfc
                cnct: 3
                qdsb: 2
                njpd: qrpf * qpfj
                wmcf: sfqt * trpz
                wqwh: 2
                wnfn: 5
                hdvs: 3
                bfmr: 2
                dsng: bnnp * djfm
                jqtp: 3
                gltt: wwhl + gfgh
                wzjc: lvpt * vjsn
                wrsz: 2
                rpbj: mvnz * lnsb
                rzng: tvht / hcmj
                grzz: 2
                zqvn: phlh + mtbc
                fbwq: 3
                tdpl: 5
                wgph: 10
                mltm: 7
                jgnd: 2
                pccg: cwtc - drwd
                jsnt: fcjc + jcgf
                zqrf: 7
                bwdn: vlzw + jdbp
                dbwp: 3
                gjfb: tztp + mtwn
                csvh: hpds + gfcp
                vdqb: 3
                pvjw: 6
                tbnt: 1
                crwq: 3
                jfsw: pwhn + mgzm
                rptr: 5
                mjcv: vtrm * wstq
                vchd: 2
                vvbw: 3
                cjpn: 16
                sssv: 3
                zgmr: tstq / vcsl
                vhqg: rhpg * tcsz
                vvnt: 2
                rtpb: rpjt * cltm
                qbmr: 10
                wqgd: 5
                pbpm: 2
                rgnd: qbhr + vvgn
                prnq: gzgm + hmfg
                lltg: vtcl + jjcz
                hdls: lrlp + wcqq
                pdpm: 2
                whcg: bgqq * wmjn
                jjgz: 15
                vvvp: 7
                bwmm: ljsv * fjgb
                lvln: 6
                tsng: pgcv + jvmw
                spgv: dmpq / prdp
                vdml: 9
                pprh: 3
                qzlv: 4
                hgmm: wfmh + fczw
                rsqv: qdwh + pdmz
                ggss: 2
                qrtp: 5
                pqgw: 6
                tgwn: mmzp * hwzq
                htcs: 4
                jlrp: 1
                cnwb: 4
                cdnv: 3
                rrbq: 19
                ndcd: 2
                jlff: 20
                cdcs: 7
                frpn: wgwn - ncbf
                tstq: hldc + wsmz
                nzjl: pbrf * cscp
                cwpz: rbcn * vmqv
                hzfz: pmpm + dsnq
                dqbj: 2
                dsvp: mrdj + sbpf
                dtwf: 9
                mnpg: wqnb + fvtw
                gfbn: lwvz - jwtd
                zmdl: cbhn + swww
                psfq: bjjq * qpgc
                cjcg: 3
                zdld: 4
                zbmp: cpdp + mbwv
                lcjs: mfvs * mpng
                vrwg: 2
                vgwn: 16
                bcqh: hhwd * szlv
                ctch: 4
                vhct: 2
                tzzv: tzmd * zhdg
                zbmv: 3
                wmbz: hlpp + ntfh
                stlq: gzdr + bmwm
                tqdl: hnwv + qhzz
                pbqm: qwtb * fdzw
                cpgj: 2
                wstq: 2
                rpth: 3
                mjcd: 19
                ncqm: 5
                ghjd: 2
                lmlb: srbb * gnsr
                tbrh: 5
                bzwp: dvqn / pprh
                gfgh: 1
                cttz: brjp * dzhq
                gbvr: 9
                wlph: zfpl * ctlp
                thdt: ncds + lmjd
                rbfp: zzvq + vmms
                spbq: 1
                jzwp: qpbm + bmdz
                cqtd: 5
                jqpw: 9
                llsl: wpbc - vftv
                hlpp: hcpq * mhml
                ghfh: sbvb * dvgg
                ccqw: gvrw + rccj
                qhpb: 7
                dgpq: 7
                lldj: 4
                sgnq: dpwc + sjfj
                rjqz: 8
                cnzt: 3
                zmwj: ssgg * sjbc
                fzgs: nplt + smfh
                mdnl: 18
                jczz: 5
                svcw: vjph * mbqv
                lmjd: 5
                zljr: 7
                pnfs: 7
                dbvg: 2
                qrpt: 12
                mvwl: 2
                wwpr: 2
                jmps: qhbp * wtqr
                prgt: flcs / wqwh
                hlfr: 6
                jfrq: 3
                tzfm: zhcv * vjgn
                rjlv: zcjl * cscr
                pgrv: 2
                qgvm: cwpz / njbv
                qjnm: 17
                qngp: 7
                rcdn: znvn - rgtv
                mnjb: 3
                hjqj: srwg + fprf
                qzgr: 10
                qlvb: 3
                grhv: pzsn * cjnr
                dcqh: zfcd / rtbf
                qbhj: 7
                tzvn: zjlq * vlrf
                qqhb: flmd + cfwc
                hqcl: ngdd * cpww
                nsng: 11
                ncds: 2
                tnwh: ndtg * mrmv
                bhns: mspz + vqwt
                wcsw: 3
                jqcr: 4
                ghlc: 2
                pgwf: vsvw * tqhr
                bcvv: bzcs * ldnt
                zqzr: bhzt * psfc
                mnmj: sbrt * jlcj
                qzrf: lmbj * qtdz
                fsgn: qmbz / trmj
                ggcc: 5
                bhcd: bbqc * qqtw
                wmws: 3
                wsbg: jgcj * nmzb
                bzqn: 5
                qpdq: snpc + wvpp
                jpmz: 19
                qtdz: fwdz + tsjc
                gqnc: hgvg * dpnz
                grzm: jcdg + njvq
                bsbm: 8
                lpbb: 5
                qhzs: 5
                ncfr: dclz + djgv
                mbqv: sblh + vmqd
                dzjn: 2
                pmfs: 3
                glmr: rtpb * rvmr
                pvcn: fwcv * rccd
                nvdd: qbvl * jzwp
                mftd: lznd * mvzd
                sbfp: fdqw + nsnp
                thfc: 7
                bcgj: 3
                vltq: mjzv / nnqg
                mhzb: plvz / sgdf
                pvjr: hnqz / qmvr
                wdnq: lgws + bbbd
                nhbp: cmnw + lrdl
                gbwj: 2
                fndh: 4
                cbqr: qfch * sjhm
                ghms: qlgq * pcpf
                vvpd: 12
                mnzz: 2
                rvgr: fdvv * hvgm
                qrpf: 13
                hdfh: lgbw * hjmj
                dsss: qssq + hcds
                dmtb: pfqp * fvrd
                dzjp: 13
                jfnc: 2
                dcrj: 5
                sfqt: 17
                zsjr: 3
                cglb: znqj + bthb
                gngh: 2
                mfpv: sssv * fmqg
                vbcd: 2
                lljg: 8
                mzjp: 4
                rrvq: 3
                glhg: rfwt * dgds
                vnrv: mjpn / pgpm
                pmpm: pjmn * jtzf
                fvbj: 2
                plvz: pcfh * cslv
                ctbl: vdvg * btls
                ngdp: 5
                lpgt: jrsr * stcd
                pcrb: rzns * mcqt
                zczz: 10
                qpzm: sggd * wszd
                dmqn: szsp * gfhr
                wjgw: lrfn - zjbg
                qmcf: wjgl - spbq
                qgbn: jntt * thvc
                bslw: 5
                wtnc: fcst * qvgw
                dpcr: zmbv + bzlt
                czjz: 3
                vhzf: 7
                vtcl: pmlc + jtch
                qrzj: 11
                fpjg: 3
                jjzh: 2
                qsth: 1
                qcrl: 14
                jrsq: nmqq * rrvq
                jtzf: 3
                jqvg: 3
                frlj: vwct * bdpp
                trfj: jhjl * djtt
                jgwc: tpnc * pgwf
                dszv: qcrl + nhtv
                bpcn: nfpr * htgj
                jctg: 2
                vglf: zpwv + zjds
                qwgl: dlcc * vmsg
                tdcf: pjpm * dlrv
                jmmj: 1
                bppq: 1
                nlps: 5
                rzgt: jlqh + mmlf
                wphg: zvsf * ftnh
                zzfg: lfgt / qttm
                tbjr: cgcq * szdl
                hrmh: gbnq * qgwl
                tvwp: 4
                zbrj: 3
                rsgv: 7
                cvrn: jwfn * dndr
                bjjq: 2
                ccdg: 2
                hnzn: 7
                mgdj: bfdg - rwqb
                tftn: jhwj + vmdf
                root: wdzt + dffc
                tvhh: 3
                cbpz: 4
                hlfh: 3
                bqwd: 11
                hbfc: 3
                mfvs: 11
                fpjr: vhct * ldgm
                dmrd: 2
                thfl: 3
                lvvb: jrnm - zrsw
                dldt: 2
                pqml: 9
                rzql: zncs * zmrw
                vfzs: jmrl * gqpn
                lplp: vqnz * zwjb
                qrhp: 10
                bqfp: pnjn * hjcc
                dqqr: lczq / fmzq
                swmb: jcbp * szzq
                swww: 2
                cmnr: hcbf + qqqq
                vqwf: bwbq * jpmz
                prdp: 2
                rclp: 5
                rvjn: bwlw * cjpn
                vmlh: vbst * pqhj
                cgqr: cfvw * zmsf
                nhnp: cfhd / znbd
                jfjg: 2
                nbrn: wcnf * wwfn
                qjwm: zwsm * wglf
                tmrl: 2
                nbtc: mqmr * bfqv
                ptnb: fwpp * zwtc
                njbv: 2
                rhpg: rhcw + tbfq
                glnz: dnpr * gmcj
                rnwf: vcbf + nrmd
                dgds: pjtc + tchm
                sfcg: 20
                tnmf: hgzd + ggbg
                gjqc: mpwq * mgpt
                ppgl: 3
                wnlp: rgnd + zhvg
                bvnj: 1
                vbst: 2
                nctw: zlpn + sfgc
                ggjr: bllc * nzhm
                znsn: nzbr + wncq
                nzdv: fnjj * mnrb
                fgft: 2
                pcbj: tgdb * gqtc
                vqwt: zpwj + crwl
                rnjm: 2
                hsrl: pbpt * dpbm
                ccgr: 2
                rgcz: rjqz + mhzb
                mgww: hjgt + tjhv
                jppq: 3
                npvw: 3
                nbrz: hhbp * vtbn
                hgzd: pvpj * cllm
                tvsg: jsdq - bftd
                bsfs: 3
                mcrv: pdst + fqbh
                phwj: cglb - wsbg
                twqg: 2
                jdwr: nsmf * pqpr
                vsvw: 3
                cdch: njpd + dgqm
                vjzs: zzfg * vjvc
                cmvb: 1
                rgvz: 3
                cmmb: zwww * dnzj
                nsnp: 17
                rhfv: fdrg * wssv
                qbqj: 6
                mhrs: 11
                trzl: 2
                blqn: tbpr / nzjw
                rjzc: 3
                qpmg: lwbc * vdrm
                dqbp: 14
                mlzh: 3
                wqnb: 5
                qdnb: hbzd - jsbp
                trcg: qfzh * qrsn
                cmnw: dhcb / dwwd
                qlpp: 14
                zgtj: 3
                sngs: 4
                qbbm: wflj * qgvm
                nrmd: clbd + vwgm
                gnjn: pjff * smcg
                lhqv: 13
                vcsf: 5
                pqhj: 11
                lnbt: pvjn + qcnf
                dvvl: 4
                vjph: 9
                zpqg: ggft + ltsw
                rqph: 5
                ngnz: thqh + rwvv
                wffm: 4
                csfw: 11
                zrbr: pmrw + spmj
                dvgf: qrpt * cmsb
                zmsf: 2
                sbrt: 2
                tjtb: flvf + rtvq
                rgzj: 1
                nbqz: 9
                qlhs: trfj * ncfr
                tpzb: 19
                hnwv: 5
                tndn: 4
                hprm: 2
                whtb: hrmh + bwlf
                tznm: jmps - cqvs
                chhc: lmpn - nvbc
                rwtn: shzm * jczl
                mqwl: 8
                mbvb: brmj * rqvv
                qjsr: 2
                hbcz: twmr * mvwl
                rrmw: dcgh - ztlt
                rprw: 5
                wwph: 9
                tvvc: 6
                ghwj: dmcf + tqml
                ghcm: 18
                ftpz: 5
                bshl: dbgj * wclz
                mtbr: mslv * rzst
                phjw: pfhj * vdqb
                vcjz: hzfz - qtqs
                lggj: qrjg - mdqq
                rcww: 2
                dlrv: 2
                ggft: ljjm + hzjf
                chmj: 2
                rrvh: 19
                fjpf: 2
                tchm: 12
                hfwm: btvd + rtrs
                lqqz: 4
                rhsv: qpmg + qttv
                bcpb: hrdz * rgff
                szjh: cdnv + pdlj
                mdwl: 3
                lfdz: 5
                nrmw: 3
                nlzp: wcsw * fzfq
                jgtg: 4
                jwpq: 5
                sbpw: 4
                fjdf: 3
                wndm: zbrj * vflq
                hdrq: 13
                nqbf: jlsc * qpfz
                jqlb: bgpc * jvcw
                tqzj: llpv + zgzs
                wtbs: 11
                fczw: rzcn + fqbn
                rsqb: mprb * mrsw
                vrdt: fctp + fgwt
                pdlj: zczz * bnbj
                wclz: dprq / hhtc
                mjzv: mrtb * pvhw
                jmjg: cwbg + tpbc
                tvvl: mdlj + bpcn
                qdwh: gczj * mgdj
                cmbc: zslt + vghz
                mfsb: hsrl + dlgt
                mnrb: 4
                nzzc: 6
                gqpn: 5
                fshc: 17
                rqlt: nzjr * wjzt
                dprm: 11
                qgtg: nwcz - cbqr
                sfrb: hnzn * qcqz
                dvfz: djpj + cnwb
                gjts: tlwn - rvzr
                rtbf: 2
                lrth: 2
                qcfp: 1
                qvtd: tnwh + tlmc
                zphj: gwfs + qdlf
                bbqc: qzmq + fgcr
                lddf: 5
                pvgm: frwj - wcdj
                mvlj: vvlb * trhq
                phlh: jvth - qctl
                rwsv: 11
                twpr: 4
                zpwj: zsmp * pppt
                dzzw: 2
                wssv: zpgq * ctms
                gqbt: wqgd * pvzt
                nllp: 17
                hzjl: pbgh * pfqw
                hhch: svbv * sdbl
                nfcd: lpqp * dqnf
                gnbv: rhfv + rmvj
                gtnh: bcvv / pvmq
                gdbh: 5
                cpcw: 1
                dpwc: 14
                mgpt: sfrb / sfnz
                cslv: slrl + rqpw
                vncm: 3
                vbsl: qhmp * grqj
                blnl: rwmj * tdpl
                pvpd: 2
                wjjd: rsfd * spsb
                vczb: qjnm * hgfs
                ctqb: 11
                thzt: wtmd * mrlb
                tpbc: zlrr * mfrz
                qgfl: 2
                hrnt: pjgb * sbhf
                rzhm: qwgl + sjtp
                bftd: mzqt / htdb
                qwqv: 4
                jnjs: 3
                wgnd: vqwf + hpzq
                gfqm: 3
                ssgg: 3
                wwlh: 6
                jllq: 2
                vqwd: rczz + cdjd
                cfmp: 3
                gqnj: qqhp * trcg
                cpwj: gfbn + nvvm
                tmpp: rpjq * jcpn
                djjj: frlj * gbjq
                rtcf: ncll * jmhq
                bhzt: 16
                vftv: trzl * rzqd
                fdqw: hgqs * ngbt
                vzvb: 4
                ndmg: 9
                jgdr: zzlj * fshc
                gpgg: mbqc * lljg
                zslt: vvtq + jddv
                ffvc: lcnz * ghjd
                fcwf: 6
                gshz: 2
                cddj: qrdt * jjzh
                cjvz: 9
                pqsr: thtt + tqdn
                trdp: qljh + fdbh
                qcff: 2
                rcrd: 3
                zdmq: 4
                gmgj: jfnc + dcrj
                rnsm: 3
                vmfl: 5
                qbgt: 13
                zczt: 4
                wbhr: 4
                hgdw: 14
                mlrl: 5
                fsfn: trtp / qqqz
                nfzz: hpjn * gmhz
                jhfr: plrb * bbdn
                hjdh: 2
                jcpn: qhfc + rbms
                bcgw: 6
                rqbn: sngs * qgqf
                htnn: 4
                szbh: 2
                szrj: 15
                zlpn: wbhr * mtcc
                qrsm: 3
                mfrz: 8
                ccwp: 3
                wgbn: 2
                mtwn: cpjj + djnv
                gfrv: 3
                qgqf: 2
                sqlq: zbfz * tqrs
                pfqp: nfcd - bbfv
                jmwm: 4
                fqbn: hfct * mlrl
                rptm: 5
                drgl: 9
                rlgw: 9
                btlj: 17
                fwpp: 7
                cwsp: 2
                jsbp: 4
                nzjf: dlmg + hvss
                bvvw: vzgf - ssdh
                gqdf: jnjs * vdml
                jtch: 8
                cdjd: 5
                rrqg: 3
                glfp: bmww * sfpq
                cwbg: zrwm * tjbs
                lzql: vhnw + qpwp
                hbzd: bzjj * gtnl
                gnhj: 2
                mnhj: 2
                tmgg: 3
                bwpd: 5
                dprq: ptvp * jqtp
                jlsc: 5
                fmrs: 3
                bvdc: 13
                qssq: 10
                vdnr: 2
                htzc: pzss + pnht
                vdrm: 2
                wtqr: wsjn * cdcs
                wfwm: 2
                vmcd: 3
                dddb: 8
                jldw: thff + hfcq
                vcvv: 15
                cwjn: 5
                ldvr: 2
                zshv: wfrw * zmcf
                zfbd: fgft + gftl
                fbjf: 12
                swcz: pqml + rgcz
                lcdb: 2
                tbpr: tzjt * dcqq
                vljt: gqbt - lsnn
                rgnn: hcps + ghms
                rpcl: 1
                jgcj: qbwb * szzv
                htgj: 2
                mmps: clrh * qlzl
                rjmg: cffs + nwjb
                zhdg: vhfw * lnzh
                ccdv: cgzz * zgmr
                lzvv: qlpp - gfrv
                pdqb: jghq + mthh
                dnzn: tlmn * vvbw
                zstf: qccf * znzb
                wgnj: sbbw - qlff
                lmbj: wdsg + btsf
                zfpq: cdbm * pbgs
                fzlz: 1
                bmvh: tcvb - sfcg
                gcps: 3
                dwwd: 2
                dhmg: fwrv * ctdh
                slrm: 12
                zmrw: 19
                svfv: 5
                nmqq: 8
                zvnv: tbjr + fvsm
                chdz: 5
                wsnf: rfsf + tjsm
                wpbc: stgc * pzmd
                vqcm: 11
                fgwl: 3
                vqnz: 8
                ljrs: frpn + pbvv
                hgsq: 2
                mfjc: gdcj * cmrf
                cngl: 2
                dnhv: bcgv * fvvz
                fdsq: 2
                dmln: qfll * nvdd
                dwdd: 2
                zffh: 2
                vgnc: 6
                rvdt: 1
                jchb: rgtr - rvht
                gzdr: 14
                qczw: 3
                sjhm: ngpz + gcrd
                hvrh: fcws / nwch
                pwhn: mglp + tmpp
                brzd: 2
                qqtw: 5
                rngd: jtnm * mfpv
                zhvj: ghfh + cmfj
                nmlw: szzh * plvt
                rljt: 3
                vbch: bwjn * jctg
                cnrq: pgtm / chmj
                tghz: fngp * zqrf
                cscr: ccgc + lsgc
                httd: tglm * hlwr
                spfv: ccwp * bfbn
                bcgv: dvqt * rrqg
                nfpr: pbdh + nbrc
                shpn: lbbg * gbvr
                fvfd: 2
                plvt: hdfh * dsts
                gfmz: vplc * btvl
                jfdb: 3
                gvfs: 3
                sbhf: 4
                pwsq: 5
                zvzb: 4
                ltlv: 3
                fcfq: 3
                gsdr: zbmp / wccn
                fdwl: ssch * jcfb
                rmms: hrhn + wgqg
                fcst: 7
                wlmp: tnlb * jmdp
                btwf: lccq + znvm
                mcns: cpdm + tpgj
                nnqg: 2
                rqjc: gqnc + lgww
                sqbf: 5
                dvgg: 6
                mjpn: wppp * rljt
                ltjn: mbvq + mjsv
                jwhz: 2
                cjrn: lcnn + rjmt
                jsvl: tlsz - rpth
                pcvz: rqbt * ggss
                wpgc: bsrv + jdrv
                htvh: 2
                bzlt: nnbr + dttc
                jvhs: 2
                tqjj: 19
                jmhq: pzfw + lplp
                dtbl: tjht * fbwq
                dqnf: bzwp - pwfw
                rhhf: 2
                sqcf: djdv * ctmf
                pvmq: 2
                csmw: 4
                nzjw: 2
                nccm: 3
                cfnw: 4
                vzsv: hqtw - gnjn
                nfnl: 1
                hqtc: wjjl * gnmc
                zntn: 3
                nfnr: 3
                gzsl: 2
                zrsw: jgln * qbsq
                btqp: 1
                dvfj: wdgv + fddn
                ntdw: ztqm * zmqv
                znwc: tgpl + vmmp
                fhjf: gwqz * jzgf
                zwsm: fhnn / zwfq
                qqqz: 3
                bmbg: qqpl + hzbw
                lclg: czcn + dqbj
                wgqg: 3
                tftw: hmzj * gpcr
                mbfm: 4
                snpd: vvvp * tmjf
                wsmz: nphl * bggm
                qctl: 2
                hpds: 9
                nphl: 15
                wtst: jrtd * gsss
                qwvl: 3
                hgwv: zftl * wfwj
                ctgs: cnct * fjpf
                fcjc: 13
                tdwm: rzsw - wdzp
                jcfb: 14
                rhcw: vljt * ccdg
                cpwm: gbcj * mdth
                hzjf: 2
                pwjm: fbjz * wpgc
                ttwc: qsbs * szsg
                qbhr: 2
                jrnm: jtzb / fgwl
                bpnj: 7
                lltb: tjfp + nnms
                rjfq: bqwd + fmrj
                btbn: csrt + ptnb
                mrhl: vffv * hvgg
                qqpl: 19
                fvvz: 2
                cpww: 4
                clmz: 6
                pzss: 14
                vjvc: ncqm + vztr
                mmtt: twqg * jtsc
                gwfs: tpgl * svrj
                stcg: 4
                wnmq: 9""";
        MonkeyRiddleGame cut = new MonkeyRiddleGame(input);
        assertThat(cut.getShoutingNumberOf("root")).isEqualTo(54703080378102L);
    }
}