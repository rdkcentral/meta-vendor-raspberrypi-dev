#--------------------------------------------------------------------------------
#Description: Tools and other component referring these variable.
#Note:	It can be removed phase2
#---------------------------------------------------------------------------------
#

RDK_GIT ?= "gerrit.teamccp.com:29418"
RDK_GIT_PROTOCOL ?= "ssh"


#TODO XiOne: These repo's are referred by meta-rdk-oss-reference. Once we have oss delivery this can be addressed.
CMF_GIT_ROOT ?= "git://code.rdkcentral.com/r"
CMF_GIT_PROTOCOL ?= "https"
CMF_RDK_COMPONENTS_ROOT_GIT ?= "${CMF_GIT_ROOT}/rdk/components"
CMF_RDKB_COMPONENTS_ROOT_GIT ?= "${CMF_GIT_ROOT}/rdkb/components"
CMF_RDKB_CCSP_ROOT_GIT ?= "${CMF_RDKB_COMPONENTS_ROOT_GIT}/opensource/ccsp"
CMF_GIT_BRANCH ?= "rdk-next"
CMF_GIT_MASTER_BRANCH ?= "master"
CMF_GIT_SRC_URI_SUFFIX = "protocol=${CMF_GIT_PROTOCOL};nobranch=1"

CMF_GITHUB_ROOT ?= "git://github.com/rdkcentral"
CMF_GITHUB_MAIN_BRANCH ?= "main"
CMF_GITHUB_MASTER_BRANCH ?= "master"
CMF_GITHUB_STABLE2_BRANCH ?= "topic/rdke_mvp"

#TODO XiOne: These repo's are referred by secapi component. Once we start using the rdke github this can be removed.
RDK_CPC_ROOT_GIT ?= "git://${RDK_GIT}/rdk/components/cpc"
RDKB_CCSP_CPC_ROOT_GIT ?= "git://${RDK_GIT}/rdk/rdkb/components/cpc"
RDKE_GITHUB_ROOT ?= "git://git@github.com/rdk-e"
RDKE_GITHUB_BRANCH ?= "develop"
RDKE_GITHUB_PROTOCOL ?= "ssh"
RDKE_GITHUB_SRC_URI_SUFFIX = "protocol=${RDKE_GITHUB_PROTOCOL};nobranch=1"
RDK_GENERIC_ROOT_GIT ?= "git://${RDK_GIT}/rdk/components/generic"
