FROM amazonlinux:latest
ARG version=11.0.15.9-1

RUN set -eux \
    && export GNUPGHOME="$(mktemp -d)" \
    && curl -fL -o corretto.key https://yum.corretto.aws/corretto.key \
    && gpg --batch --import corretto.key \
    && gpg --batch --export --armor '6DC3636DAE534049C8B94623A122542AB04F24E3' > corretto.key \
    && rpm --import corretto.key \
    && rm -r "$GNUPGHOME" corretto.key \
    && curl -fL -o /etc/yum.repos.d/corretto.repo https://yum.corretto.aws/corretto.repo \
    && grep -q '^gpgcheck=1' /etc/yum.repos.d/corretto.repo \
    && echo "priority=9" >> /etc/yum.repos.d/corretto.repo \
    && yum install -y java-11-amazon-corretto-devel-$version \
    && (find /usr/lib/jvm/java-11-amazon-corretto -name src.zip -delete || true) \
    && yum install -y fontconfig \
    && yum clean all

RUN yum install -y unzip wget
RUN wget https://services.gradle.org/distributions/gradle-7.4.1-bin.zip
RUN mkdir /gradle
RUN unzip gradle-7.4.1-bin.zip -d /gradle
RUN echo 'export GRADLE_HOME=/gradle/gradle-7.4.1' >> $HOME/.bashrc
RUN echo 'export PATH=$PATH:$GRADLE_HOME/bin' >> $HOME/.bashrc
RUN /bin/bash -c "source $HOME/.bashrc"
ENV GRADLE_HOME=/gradle/gradle-7.4.1
ENV PATH=$PATH:$GRADLE_HOME/bin
ENV LANG C.UTF-8
ENV JAVA_HOME=/usr/lib/jvm/java-11-amazon-corretto

RUN java --version
RUN gradle --version

CMD ["/bin/bash"]